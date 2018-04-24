package blog.home.service;

import blog.home.model.Enjoy;

public interface IEnjoyService {
  
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
   * @Description: 根据文章ID和用户ID查找 喜欢详情
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
