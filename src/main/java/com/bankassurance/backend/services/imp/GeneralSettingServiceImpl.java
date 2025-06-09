package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.repository.entity.GeneralSetting;
import com.bankassurance.backend.repository.rep.GeneralSettingRepository;
import com.bankassurance.backend.services.userservices.GeneralSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneralSettingServiceImpl implements GeneralSettingService {
    private final GeneralSettingRepository repository;

    @Override
    public GeneralSetting create(GeneralSetting setting) {
        return repository.save(setting);
    }

    @Override
    public List<GeneralSetting> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<GeneralSetting> update(Integer id, GeneralSetting setting) {
        return repository.findById(id).map(existing -> {
            existing.setThreshold(setting.getThreshold());
            existing.setDelay(setting.getDelay());
            existing.setPath(setting.getPath());
            return repository.save(existing);
        });
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
