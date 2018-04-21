package blog.home.dao;

import java.util.List;

import blog.home.model.Collect;
import blog.home.model.po.ArticleCollectPo;
import blog.home.model.po.CollectPo;

/**  
 * @ClassName: CollectMapper  
 * @Description: 操作数据库blog_collect博客文章收藏表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface CollectMapper {
  
  /**  
   * @Title: addCollect
   * @Description: 添加用户文章收藏信息
   * @return void
   * @throws
   */
  public void addCollect(Collect collect);
  
  /**  
   * @Title: deleteCollect
   * @Description: 删除用户文章收藏信息
   * @return void
   * @throws
   */
  public void deleteCollect(int cid);
  
  /**  
   * @Title: deleteCollectBatch
   * @Description: 批量删除用户文章收藏信息
   * @return void
   * @throws
   */
  public void deleteCollectBatch(List<Integer> idList);
  
  /**  
   * @Title: findCollectByUser
   * @Description: 根据 用户ID 查询用户文章收藏信息
   * @return CollectPo
   * @throws
   */
  public CollectPo findCollectByUser(int uid);
  
  /**  
   * @Title: findCountByUser
   * @Description: 根据 用户ID 查询用户文章收藏数量
   * @return int
   * @throws
   */
  public int findCountByUser(int uid);
  
  /**  
   * @Title: findCollectById
   * @Description: 根据 文章收藏ID 查找用户文章收藏信息
   * @return ArticleCollectPo
   * @throws
   */
  public ArticleCollectPo findCollectById(int cid);
  

}
