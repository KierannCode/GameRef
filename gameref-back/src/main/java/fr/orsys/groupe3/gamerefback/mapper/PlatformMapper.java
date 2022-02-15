package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.dto.PlatformDto;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapper {
    public Platform mapPlatform(Platform platform, PlatformDto dto) {
        platform.setName(dto.getName());
        return platform;
    }
}
