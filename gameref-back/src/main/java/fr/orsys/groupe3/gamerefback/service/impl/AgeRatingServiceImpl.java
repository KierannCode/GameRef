package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import fr.orsys.groupe3.gamerefback.dao.AgeRatingDao;
import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import fr.orsys.groupe3.gamerefback.mapper.AgeRatingMapper;
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
        ageRatingMapper.mapAgeRating(ageRating, dto);
        return ageRatingDao.save(ageRating);
    }

    @Override
    public List<AgeRating> getAgeRatings() {
        return ageRatingDao.findAll();
    }
}
