package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.dto.PlatformDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlatformService {
    Platform createPlatform(PlatformDto dto);

    Platform getPlatform(Long id) throws NotFoundException;

    List<Platform> getPlatforms();
}
