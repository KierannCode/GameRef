package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.dao.PlatformDao;
import fr.orsys.groupe3.gamerefback.dto.PlatformDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.mapper.PlatformMapper;
import fr.orsys.groupe3.gamerefback.service.PlatformService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatformServiceImpl implements PlatformService {

    private PlatformMapper platformMapper;
    private PlatformDao platformDao;

    @Override
    public Platform createPlatform(PlatformDto dto) {
        Platform platform = new Platform();
        platformMapper.mapPlatform(platform, dto);
        return platformDao.save(platform);
    }

    @Override
    public List<Platform> getPlatforms() {
        return platformDao.findAll();
    }

    @Override
    public Platform getPlatform(Long id) throws NotFoundException {
        return platformDao.findById(id).orElseThrow(() -> new NotFoundException("No platform found with id " + id));
    }
}
