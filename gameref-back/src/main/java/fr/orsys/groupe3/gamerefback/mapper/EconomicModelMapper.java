package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.EconomicModel;
import fr.orsys.groupe3.gamerefback.dto.EconomicModelDto;
import org.springframework.stereotype.Component;

@Component
public class EconomicModelMapper {
    public EconomicModel mapEconomicModel(EconomicModel economicModel, EconomicModelDto dto) {
        economicModel.setName(dto.getName());
        return economicModel;
    }
}
