package blog.home.dao;

import blog.home.model.Attention;

/**  
 * @ClassName: AttentionMapper  
 * @Description: 操作数据库user_attention用户关注表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface AttentionMapper {
  
  /**  
   * @Title: addAttention
   * @Description: 添加用户关注信息
   * @return void
   * @throws
   */
  public void addAttention(Attention attention);
  
  /**  
   * @Title: deleteAttention
   * @Description: 删除用户关注信息
   * @return void
   * @throws
   */
  public void deleteAttention(Attention attention);
  
  /**  
   * @Title: findAttentionByUser
   * @Description: 根据 关注人ID 查询用户关注信息 
   * @return TODO
   * @throws
   */
  public void findAttentionByUser(int uid);
  
  /**  
   * @Title: findCountByUser
   * @Description: 根据 关注人ID 查询用户关注数量
   * @return void
   * @throws
   */
  public int findCountByUser(int uid);
  
  /**  
   * @Title: findCountByUid
   * @Description: 根据 被关注人ID 查询用户被关注数量
   * @return int
   * @throws
   */
  public int findCountByUid(int uid);
  
}
