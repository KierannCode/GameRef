package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Category;
import fr.orsys.groupe3.gamerefback.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category mapCategory(Category category, CategoryDto dto) {
        category.setName(dto.getName());
        return category;
    }
}
