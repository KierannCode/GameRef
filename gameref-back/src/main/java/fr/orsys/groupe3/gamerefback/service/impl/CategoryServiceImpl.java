package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Category;
import fr.orsys.groupe3.gamerefback.dao.CategoryDao;
import fr.orsys.groupe3.gamerefback.business.dto.CategoryDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.business.mapper.CategoryMapper;
import fr.orsys.groupe3.gamerefback.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryMapper categoryMapper;

    private CategoryDao categoryDao;

    @Override
    public Category createCategory(CategoryDto dto) {
        Category category = new Category();
        categoryMapper.mapCategory(category, dto);
        return categoryDao.save(category);
    }

    @Override
    public Category getCategory(Long id) throws NotFoundException {
        return categoryDao.findById(id).orElseThrow(() -> new NotFoundException("category", "Aucun genre trouvée avec l'id " + id));
    }

    @Override
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }
}
