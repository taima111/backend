package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.repository.configuration_entity.InsuranceConfiguration;
import com.bankassurance.backend.services.userservices.InsuranceconfigurationService;
import com.bankassurance.backend.repository.insurance_configuration_rep.InsuranceConfigurationrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceconfigurationServiceImpl implements InsuranceconfigurationService {
    @Autowired
    private InsuranceConfigurationrepository repository;

    @Override
    public InsuranceConfiguration createOrUpdate(InsuranceConfiguration config) {
        return repository.save(config);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<InsuranceConfiguration> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<InsuranceConfiguration> getById(Long id) {
        return repository.findById(id);
    }
}