package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Category;
import fr.orsys.groupe3.gamerefback.business.dto.CategoryDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createCategory(CategoryDto dto);

    Category getCategory(Long id) throws NotFoundException;

    List<Category> getCategories();
}
