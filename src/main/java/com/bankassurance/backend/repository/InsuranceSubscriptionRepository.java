package com.bankassurance.backend.repository;

import com.bankassurance.backend.repository.insurance_sub_entity.InsuranceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceSubscriptionRepository extends JpaRepository<InsuranceSubscription,Long> {
}
