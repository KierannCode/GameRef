package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.Category;
import fr.orsys.groupe3.gamerefback.business.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category mapCategory(Category category, CategoryDto dto) {
        if (dto.getName() != null) {
            category.setName(dto.getName());
        }
        return category;
    }
}
