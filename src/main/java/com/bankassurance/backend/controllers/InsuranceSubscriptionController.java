package com.bankassurance.backend.controllers;

import com.bankassurance.backend.repository.insurance_sub_entity.InsuranceSubscription;
import com.bankassurance.backend.services.subscriptionservices.InsuranceSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/insurance-subscriptions")
@RequiredArgsConstructor
public class InsuranceSubscriptionController {


    private final InsuranceSubscriptionService insuranceSubscriptionService;

    @GetMapping
    public ResponseEntity<List<InsuranceSubscription>> getAllSubscriptions() {
        List<InsuranceSubscription> subscriptions = insuranceSubscriptionService.getAllSubscriptions();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceSubscription> getSubscriptionById(@PathVariable long id) {
        Optional<InsuranceSubscription> subscription = insuranceSubscriptionService.getSubscriptionById(id);
        return subscription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InsuranceSubscription> createSubscription(@RequestBody InsuranceSubscription insuranceSubscription) {
        InsuranceSubscription createdSubscription = insuranceSubscriptionService.createSubscription(insuranceSubscription);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceSubscription> updateSubscription(@PathVariable long id, @RequestBody InsuranceSubscription insuranceSubscription) {
        Optional<InsuranceSubscription> updatedSubscription = insuranceSubscriptionService.updateSubscription(id, insuranceSubscription);
        return updatedSubscription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable long id) {
        boolean isDeleted = insuranceSubscriptionService.deleteSubscription(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}