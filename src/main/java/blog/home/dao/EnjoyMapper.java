package blog.home.dao;

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
  public void deleteEnjoy(int id);
  
  /**  
   * @Title: findEnjoyByArticle
   * @Description: 根据文章ID和用户ID查找喜欢详情
   * @return Enjoy
   * @throws
   */
  public Enjoy findEnjoy(Enjoy enjoy);
  
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
