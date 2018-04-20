package blog.home.dao;

import java.util.List;

import blog.home.po.Collect;

/**  
 * @ClassName: CollectMapper  
 * @Description: 操作数据库blog_collect博客文章收藏表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface CollectMapper {
  
  /**  
   * @Title: addCollect
   * @Description: 添加用户收藏博客文章信息
   * @return void
   * @throws
   */
  public void addCollect(Collect collect);
  
  /**  
   * @Title: deleteCollect
   * @Description: 删除用户收藏博客文章信息
   * @return void
   * @throws
   */
  public void deleteCollect(int id);
  
  /**  
   * @Title: deleteCollectBatch
   * @Description: 批量删除用户收藏博客文章信息
   * @return void
   * @throws
   */
  public void deleteCollectBatch(List<Integer> idList);
  
  /**  
   * @Title: findCollectByUser
   * @Description: TODO(这里用一句话描述这个方法的作用)
   * @return TODO
   * @throws
   */
  public void findCollectByUser(int user_id);

}
