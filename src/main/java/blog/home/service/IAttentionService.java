package blog.home.service;

import java.util.List;

import blog.home.model.Attention;

public interface IAttentionService {
   
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
   * @return List<Attention>
   * @throws
   */
  public List<Attention> findAttentionByUser(int uid);
  
  /**  
   * @Title: findAttentionCount
   * @Description: 根据 关注人ID 查询用户关注数量
   * @return int
   * @throws
   */
  public int findAttentionCount(int uid);
  
  /**  
   * @Title: findFansByAttention
   * @Description: 根据关注人和被关注人ID 查询用户粉丝信息
   * @return List<Attention>
   * @throws
   */
  public Attention findFans(Attention attention);
  
  /**  
   * @Title: findFansCount
   * @Description: 根据 被关注人ID 查询用户粉丝数量
   * @return int
   * @throws
   */
  public int findFansCount(int aid);
  
}
