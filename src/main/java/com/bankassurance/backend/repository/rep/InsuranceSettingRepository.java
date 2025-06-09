package com.bankassurance.backend.repository.rep;

import com.bankassurance.backend.repository.entity.InsuranceSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceSettingRepository extends JpaRepository<InsuranceSetting, Integer> {}
