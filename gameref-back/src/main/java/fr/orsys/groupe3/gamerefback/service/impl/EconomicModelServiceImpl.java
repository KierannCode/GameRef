package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.EconomicModel;
import fr.orsys.groupe3.gamerefback.dao.EconomicModelDao;
import fr.orsys.groupe3.gamerefback.business.dto.EconomicModelDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.business.mapper.EconomicModelMapper;
import fr.orsys.groupe3.gamerefback.service.EconomicModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EconomicModelServiceImpl implements EconomicModelService {
    private EconomicModelMapper economicModelMapper;

    private EconomicModelDao economicModelDao;

    @Override
    public EconomicModel createEconomicModel(EconomicModelDto dto) {
        EconomicModel economicModel = new EconomicModel();
        economicModelMapper.mapEconomicModel(economicModel, dto);
        return economicModelDao.save(economicModel);
    }

    @Override
    public EconomicModel getEconomicModel(Long id) throws NotFoundException {
        return economicModelDao.findById(id).orElseThrow(() -> new NotFoundException("economicModel", "Aucun modèle économique trouvé avec l'id " + id));
    }

    @Override
    public List<EconomicModel> getEconomicModels() {
        return economicModelDao.findAll();
    }
}
