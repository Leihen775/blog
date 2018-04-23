package blog.home.service;

import java.util.List;

import blog.home.model.Collect;

public interface ICollectService {

  /**  
   * @Title: addCollect
   * @Description: 添加用户的文章收藏信息
   * @return void
   * @throws
   */
  public void addCollect(Collect collect);
  
  /**  
   * @Title: deleteCollect
   * @Description: 删除用户的文章收藏信息
   * @return void
   * @throws
   */
  public void deleteCollect(int cid);
  
  /**  
   * @Title: deleteCollectBatch
   * @Description: 批量删除用户的文章收藏信息
   * @return void
   * @throws
   */
  public void deleteCollectBatch(List<Integer> cidList);
  
  /**  
   * @Title: updateCollect
   * @Description: 修改用户的文章收藏信息
   * @return void
   * @throws
   */
  public void updateCollect(Collect collect);
  
  /**  
   * @Title: findCollectByUser
   * @Description: 根据 用户ID 查询用户的文章收藏简略信息
   * @return List<Collect>
   * @throws
   */
  public List<Collect> findCollectByUser(int uid);
  
  /**  
   * @Title: findCountByUser
   * @Description: 根据 用户ID 查询用户的文章收藏数量
   * @return int
   * @throws
   */
  public int findCountByUser(int uid);
  
  /**  
   * @Title: findCollectById
   * @Description: 根据 文章收藏ID 查找用户的文章收藏信息
   * @return Collect
   * @throws
   */
  public Collect findCollectById(int cid);
  
}
