package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.business.dto.PlatformDto;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapper {
    public Platform mapPlatform(Platform platform, PlatformDto dto) {
        if (dto.getName() != null) {
            platform.setName(dto.getName());
        }
        return platform;
    }
}
