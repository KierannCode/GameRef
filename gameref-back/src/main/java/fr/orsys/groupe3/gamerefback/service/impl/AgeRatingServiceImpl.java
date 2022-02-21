package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import fr.orsys.groupe3.gamerefback.dao.AgeRatingDao;
import fr.orsys.groupe3.gamerefback.business.dto.AgeRatingDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.business.mapper.AgeRatingMapper;
import fr.orsys.groupe3.gamerefback.service.AgeRatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgeRatingServiceImpl implements AgeRatingService {
    private AgeRatingMapper ageRatingMapper;

    private AgeRatingDao ageRatingDao;

    @Override
    public AgeRating createAgeRating(AgeRatingDto dto) {
        AgeRating ageRating = new AgeRating();
        ageRating = ageRatingMapper.mapAgeRating(ageRating, dto);
        return ageRatingDao.save(ageRating);
    }

    @Override
    public AgeRating getAgeRating(Long id) throws NotFoundException {
        return ageRatingDao.findById(id).orElseThrow(() -> new NotFoundException("ageRating", "Aucune classification trouvée avec l'id " + id));
    }

    @Override
    public List<AgeRating> getAgeRatings() {
        return ageRatingDao.findAll();
    }
}
