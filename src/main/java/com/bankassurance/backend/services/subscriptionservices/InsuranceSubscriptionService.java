package com.bankassurance.backend.services.subscriptionservices;

import com.bankassurance.backend.models.enums.Status;
import com.bankassurance.backend.repository.InsuranceSubscriptionRepository;
import com.bankassurance.backend.repository.insurance_sub_entity.InsuranceSubscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
@RequiredArgsConstructor
public class InsuranceSubscriptionService {
    private final InsuranceSubscriptionRepository repository;
    public List<InsuranceSubscription> getAllSubscriptions() {
        return repository.findAll();
    }


    public Optional<InsuranceSubscription> getSubscriptionById(long id) {
        return repository.findById(id);
    }

    public InsuranceSubscription createSubscription(InsuranceSubscription insuranceSubscription) {
        insuranceSubscription.setStatus(Status.PENDING);
        return repository.save(insuranceSubscription);
    }

    public Optional<InsuranceSubscription> updateSubscription(long id, InsuranceSubscription insuranceSubscription) {
        if (repository.existsById(id)) {
            insuranceSubscription.setId(id);
            return Optional.of(repository.save(insuranceSubscription));
        }
        return Optional.empty();
    }

    public boolean deleteSubscription(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}