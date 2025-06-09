package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.repository.insurance_configuration_rep.JokerInsuranceConfigurationRepository;
import com.bankassurance.backend.repository.configuration_entity.JokerInsuranceConfiguration;
import com.bankassurance.backend.services.userservices.JokerInsuranceConfigurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokerInsuranceConfigurationServiceImpl implements JokerInsuranceConfigurationService {
    private final JokerInsuranceConfigurationRepository repository;

    @Autowired
    public JokerInsuranceConfigurationServiceImpl(JokerInsuranceConfigurationRepository repository) {
        this.repository = repository;
    }

    @Override
    public JokerInsuranceConfiguration createOrUpdate(JokerInsuranceConfiguration config) {
        return repository.save(config);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<JokerInsuranceConfiguration> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<JokerInsuranceConfiguration> getById(Long id) {
        return repository.findById(id);
    }
}