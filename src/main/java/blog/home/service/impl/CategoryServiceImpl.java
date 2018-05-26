package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.CategoryMapper;
import blog.home.model.Category;
import blog.home.service.ICategoryService;

/**  
 * @ClassName: CategoryServiceImpl
 * @Description: 
 * @author Leihen
 * @date 2018年4月19日
 */
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
  
  @Autowired
  CategoryMapper categoryMapper;

  @Override
  public void addCategory(Category category) {
    categoryMapper.addCategory(category);
  }

  @Override
  public void deleteCategory(int id) {
    categoryMapper.deleteCategory(id);
  }

  @Override
  public void deleteCategoryBatch(List<Integer> idList) {
    categoryMapper.deleteCategoryBatch(idList);
  }

  @Override
  public void updateCategory(Category category) {
    categoryMapper.updateCategory(category);
  }

  @Override
  public List<Category> findAllCategory() {
    return categoryMapper.findAllCategoryId();
  }

  @Override
  public Category findCategoryById(int id) {
    return categoryMapper.findCategoryById(id);
  }

  @Override
  public List<Category> findCategoryByName(String name) {
    return categoryMapper.findCategoryByName(name);
  }

}
