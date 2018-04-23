package blog.home.dao;

import java.util.List;

import blog.home.model.Enjoy;

/**  
 * @ClassName: EnjoyMapper  
 * @Description: 操作数据库blog_enjoy文章喜爱表dao
 * @author Leihen  
 * @date 2018年4月23日      
 */  
public interface EnjoyMapper {
  
  /**  
   * @Title: addEnjoy
   * @Description: 添加喜欢信息
   * @return void
   * @throws
   */
  public void addEnjoy(Enjoy enjoy);
  
  /**  
   * @Title: deleteEnjoy
   * @Description: 删除喜欢信息
   * @return void
   * @throws
   */
  public void deleteEnjoy(Enjoy enjoy);
  
  /**  
   * @Title: findEnjoyByArticle
   * @Description: 根据文章ID查找所有喜欢人Id
   * @return List<Enjoy>
   * @throws
   */
  public List<Enjoy> findEnjoyByArticle(int aid);
  
  /**  
   * @Title: findCountByArticle
   * @Description: 根据文章ID查找喜欢的人的数量
   * @return int
   * @throws
   */
  public int findCountByArticle(int aid);
  
  /**  
   * @Title: findCountByUser
   * @Description: 根据用户ID查找喜欢的文章的数量
   * @return int
   * @throws
   */
  public int findCountByUser(int uid);
}
