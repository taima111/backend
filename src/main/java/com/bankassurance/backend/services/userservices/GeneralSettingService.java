package com.bankassurance.backend.services.userservices;

import com.bankassurance.backend.repository.entity.GeneralSetting;

import java.util.List;
import java.util.Optional;

public interface GeneralSettingService {
    GeneralSetting create(GeneralSetting setting);
    List<GeneralSetting> getAll();
    Optional<GeneralSetting> update(Integer id, GeneralSetting setting);
    void delete(Integer id);
}
