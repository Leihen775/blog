package blog.home.service;

import java.util.List;

import blog.home.model.Category;

/**  
 * @ClassName: CategoryService
 * @Description: 
 * @author Leihen
 * @date 2018年4月19日
 */
public interface ICategoryService {
  
  /**  
   * @Title: addCategory
   * @Description: 添加文章类型
   * @return void
   * @throws
   */
  public void addCategory(Category category);
  
  /**  
   * @Title: deleteCategory
   * @Description: 根据ID删除文章类型
   * @return void
   * @throws
   */
  public void deleteCategory(int id);
  
  /**  
   * @Title: deleteCategoryBatch
   * @Description: 根据ID批量删除文章类型
   * @return void
   * @throws
   */
  public void deleteCategoryBatch(List<Integer> idList);
  
  /**  
   * @Title: updateCategory
   * @Description: 根据类型ID修改文章类型
   * @return void
   * @throws
   */
  public void updateCategory(Category category);
  
  /**  
   * @Title: findAllCategoryId
   * @Description: 查找所有文章类型
   * @return List<Category>
   * @throws
   */
  public List<Category> findAllCategory();
  
  /**  
   * @Title: findCategoryById
   * @Description: 根据ID查找文章类型
   * @return Category
   * @throws
   */
  public Category findCategoryById(int id);
  
  /**  
   * @Title: findCategoryByName
   * @Description: 根据名称查找文章类型
   * @return Category
   * @throws
   */
  public List<Category> findCategoryByName(String name);

}
