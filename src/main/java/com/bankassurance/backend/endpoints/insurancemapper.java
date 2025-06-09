package com.bankassurance.backend.endpoints;

import com.bankassurance.backend.repository.configuration_entity.DelayConfiguration;
import com.bankassurance.backend.repository.configuration_entity.JokerInsuranceConfiguration;
import com.bankassurance.backend.repository.configuration_entity.PathConfiguration;
import com.bankassurance.backend.repository.configuration_entity.ThresholdsConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface insurancemapper {

    ThresholdsConfiguration toThresholdsConfiguration(ThresholdsConfiguration thresholdsConfiguration);

    DelayConfiguration toDelayConfiguration(DelayConfiguration delayConfiguration);

    PathConfiguration toPathConfiguration(PathConfiguration pathConfiguration);

    JokerInsuranceConfiguration toJokerInsuranceConfiguration(JokerInsuranceConfiguration jokerInsuranceConfiguration);
}