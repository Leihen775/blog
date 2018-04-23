package blog.home.dao;

import java.util.List;

import blog.home.model.ArticleTag;

/**  
 * @ClassName: ArticleTagMapper  
 * @Description: 操作数据库blog_article_tag文章标签表dao
 * @author Leihen  
 * @date 2018年4月22日      
 */  
public interface ArticleTagMapper {
  
  /**  
   * @Title: addArticleTag
   * @Description: 添加文章个人标签信息
   * @return void
   * @throws
   */
  public void addArticleTag(List<ArticleTag> articleTagList);
  
  /**  
   * @Title: deleteByAid
   * @Description: 根据 一个文章ID 删除文章标签
   * @return void
   * @throws
   */
  public void deleteByAid(int aid);
  
  /**  
   * @Title: deleteByAidBatch
   * @Description: 根据 多个文章ID 批量删除文章标签
   * @return void
   * @throws
   */
  public void deleteByAidBatch(List<Integer> aidList);
  
  /**  
   * @Title: deleteByTid
   * @Description: 根据  一个标签ID 删除文章标签
   * @return void
   * @throws
   */
  public void deleteByTid(int tid);
  
  /**  
   * @Title: deleteByTidBatch
   * @Description: 根据 多个标签ID 删除文章标签
   * @return void
   * @throws
   */
  public void deleteByTidBatch(List<Integer> tidList);
  
}
