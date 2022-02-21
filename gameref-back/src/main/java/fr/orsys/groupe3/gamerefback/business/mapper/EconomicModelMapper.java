package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.EconomicModel;
import fr.orsys.groupe3.gamerefback.business.dto.EconomicModelDto;
import org.springframework.stereotype.Component;

@Component
public class EconomicModelMapper {
    public EconomicModel mapEconomicModel(EconomicModel economicModel, EconomicModelDto dto) {
        if (dto.getName() != null) {
            economicModel.setName(dto.getName());
        }
        return economicModel;
    }
}
