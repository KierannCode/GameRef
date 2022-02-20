package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.EconomicModel;
import fr.orsys.groupe3.gamerefback.dto.EconomicModelDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EconomicModelService {
    EconomicModel createEconomicModel(EconomicModelDto dto);

    EconomicModel getEconomicModel(Long id) throws NotFoundException;

    List<EconomicModel> getEconomicModels();
}
