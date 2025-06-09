package com.bankassurance.backend.config;

import com.bankassurance.backend.repository.rep.TokenRepository;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    private static final List<String> EXCLUDED_PATHS = List.of(
            "/api/v1/auth/register",
            "/api/v1/auth/authenticate",
            "/swagger-ui",
            "/swagger-ui/",
            "/v3/api-docs"
    );

    private boolean isPublicRoute(HttpServletRequest request) {
        String path = request.getRequestURI();
        return EXCLUDED_PATHS.stream().anyMatch(path::startsWith);
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        if (isPublicRoute(request)) {
            logger.info("Public route accessed: {}, skipping JWT validation", request.getRequestURI());
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");
        logger.info("Authorization header: {}", authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            logger.warn("No Bearer token found in request for URI: {}", request.getRequestURI());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
            return;
        }

        try {
            final String jwt = authHeader.substring(7);
            logger.info("Extracted JWT: {}", jwt);
            final String userEmail = jwtService.extractUsername(jwt);
            logger.info("Extracted user email from JWT: {}", userEmail);

            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                logger.info("Loaded user details for email: {}, authorities: {}", userEmail, userDetails.getAuthorities());

                boolean isTokenValidInRepo = tokenRepository.findByToken(jwt)
                        .map(token -> {
                            boolean valid = !token.isExpired() && !token.isRevoked();
                            logger.info("Token valid in repository: {}, expired: {}, revoked: {}", valid, token.isExpired(), token.isRevoked());
                            return valid;
                        })
                        .orElse(false);
                logger.info("Token repository validation result: {}", isTokenValidInRepo);

                boolean isJwtValid = jwtService.isTokenValid(jwt, userDetails);
                logger.info("JWT service validation result: {}", isJwtValid);

                if (isJwtValid && isTokenValidInRepo) {
                    logger.info("JWT is valid, setting authentication for user: {}", userEmail);
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    logger.warn("Authentication failed for user: {}. JWT valid: {}, Token valid in repository: {}", userEmail, isJwtValid, isTokenValidInRepo);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
                    return;
                }
            } else {
                logger.warn("No authentication set. User email: {}, Existing authentication: {}", userEmail, SecurityContextHolder.getContext().getAuthentication());
            }
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
            return;
        } catch (Exception e) {
            logger.error("Error processing JWT: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
            return;
        }

        filterChain.doFilter(request, response);
    }
}