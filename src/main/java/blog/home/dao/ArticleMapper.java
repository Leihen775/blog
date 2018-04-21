package blog.home.dao;

import java.util.List;

import blog.home.model.Article;
import blog.home.model.ArticleTag;
import blog.home.model.po.ArticlePo;

/**  
 * @ClassName: ArticleMapper  
 * @Description: 操作数据库blog_article博客文章表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface ArticleMapper {
   
  /**  
   * @Title: addArticle
   * @Description: 添加博客文章
   * @return void
   * @throws
   */
  public void addArticle(Article article);
  
  /**  
   * @Title: addArticleTag
   * @Description: 添加文章个人标签信息
   * @return void
   * @throws
   */
  public void addArticleTag(List<ArticleTag> articleTagList);
  
  /**  
   * @Title: deleteArticle
   * @Description: 根据 文章ID 删除文章信息
   * @return void
   * @throws
   */
  public void deleteArticle(int aid);
  
  /**  
   * @Title: deleteArticleTag
   * @Description: 根据 文章ID 删除博客文章个人标签
   * @return void
   * @throws
   */
  public void deleteArticleTag(int aid);
  
  /**  
   * @Title: deleteArticleTagByTid
   * @Description: 根据标签ID 删除文章标签信息
   * @return void
   * @throws
   */
  public void deleteArticleTagByTid(List<Integer> tidList);
  
  /**  
   * @Title: deleteArticleBatch
   * @Description: 根据 文章ID 批量删除文章信息
   * @return void
   * @throws
   */
  public void deleteArticleBatch(List<Integer> idList);
  
  /**  
   * @Title: updateArticle
   * @Description: 根据 文章ID 修改文章信息
   * @return void
   * @throws
   */
  public void updateArticle(Article Article);
  
  /**  
   * @Title: findArticle
   * @Description: 根据 文章ID 查询文章信息
   * @return ArticlePo
   * @throws
   */
  public ArticlePo findArticle(int id);
  
  /**  
   * @Title: findArticleByCategory
   * @Description: 根据 文章类别 查询博客文章信息
   * @return List<ArticlePo>
   * @throws
   */
  public List<ArticlePo> findArticleByCategory(int cid);
  
}
