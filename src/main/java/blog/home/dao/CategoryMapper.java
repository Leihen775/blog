package blog.home.dao;

import java.util.List;

import blog.home.model.Category;


/**  
 * @ClassName: CategoryMapper  
 * @Description: 操作数据库blog_category博客类别表dao
 * @author Leihen  
 * @date 2018年4月19日      
 */  
public interface CategoryMapper {
  
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
   * @Title: deleteCategory
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
   * @Title: findAllCategoryCode
   * @Description: 查找所有文章类型(根据code升序排列)
   * @return List<Category>
   * @throws
   */
  public List<Category> findAllCategoryCode();
  
  /**  
   * @Title: findAllCategoryCodeDesc
   * @Description: 查找所有文章类型(根据code降序排列)
   * @return List<Category>
   * @throws
   */
  public List<Category> findAllCategoryCodeDesc();
  
  /**  
   * @Title: findAllCategoryName
   * @Description: 查找所有文章类型(根据名称升序排列)
   * @return List<Category>
   * @throws
   */
  public List<Category> findAllCategoryName();
  
  /**  
   * @Title: findAllCategoryNameDesc
   * @Description: 查找所有文章类型(根据名称将序排列)
   * @return List<Category>
   * @throws
   */
  public List<Category> findAllCategoryNameDesc();
  
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
