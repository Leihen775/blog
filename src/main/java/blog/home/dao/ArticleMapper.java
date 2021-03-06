package blog.home.dao;

import java.util.List;

import blog.home.model.Article;

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
   * @Title: addClickCount
   * @Description: 点击数+1
   * @return void
   * @throws
   */
  public void addClickCount(int id);
  
  /**  
   * @Title: addEnjoyCount
   * @Description: 喜欢数+1
   * @return void
   * @throws
   */
  public void addEnjoyCount(int id);
  
  /**  
   * @Title: addCommentCount
   * @Description: 评论数+1
   * @return void
   * @throws
   */
  public void addCommentCount(int id);
  
  /**  
   * @Title: deleteArticle
   * @Description: 根据文章ID单个删除
   * @return void
   * @throws
   */
  public void deleteArticle(int id);
  
  /**  
   * @Title: deleteArticleBatch
   * @Description: 根据 文章ID 批量删除文章信息
   * @return void
   * @throws
   */
  public void deleteArticleBatch(List<Integer> aidList);
  
  /**  
   * @Title: minusEnjoyCount
   * @Description: 喜欢数-1
   * @return void
   * @throws
   */
  public void minusEnjoyCount(int id);
  
  /**  
   * @Title: minusCommentCount
   * @Description: 评论数-1
   * @return void
   * @throws
   */
  public void minusCommentCount(int id);
  
  /**  
   * @Title: updateArticle
   * @Description: 根据 文章ID 修改文章信息
   * @return void
   * @throws
   */
  public void updateArticle(Article article);
  
  /**  
   * @Title: findArticle
   * @Description: 根据 文章ID 查询文章详细信息
   * @return ArticlePo
   * @throws
   */
  public Article findArticle(int id);
  
  /**  
   * @Title: findAllArticle
   * @Description: 查询所有文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findAllArticle();
  
  /**  
   * @Title: findArticleByCategory
   * @Description: 根据类别ID查询文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleByCategory(int cid);
  
  /**  
   * @Title: findArticleByTitle
   * @Description: 根据 文章标题进行模糊查询 文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleByTitle(String title);
  
  /**  
   * @Title: findArticleByUser
   * @Description: 根据用户ID查询所有已发布或草稿文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleByUser(int uid);
  
  /**  
   * @Title: findArticlePublish
   * @Description: 根据用户ID查询所有已发布文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticlePublish(int uid);
  
  /**  
   * @Title: findArticleDraft
   * @Description: 根据用户ID查询所有草稿文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleDraft(int uid);
  
  /**  
   * @Title: findArticleGarbage
   * @Description: 根据用户ID查询所有已删除文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleGarbage(int uid);
  
  /**  
   * @Title: findArticleCountByTag
   * @Description: 根据 "用户"标签ID查询该类文章数量
   * @return int
   * @throws
   */
  public int findArticleCountByTag(int tid);
  
  /**  
   * @Title: findArticleByTag
   * @Description: 根据 "用户"标签ID查询文章简略信息(按时间排序)
   * @return List<ArticlePo>
   * @throws
   */
  public List<Article> findArticleByTag(int Tag);
  
  /**  
   * @Title: findArticleByUserTitle
   * @Description: 根据 "用户"标题模糊查询文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleByUserTitle(Article Article);
  
  /**  
   * @Title: findArticleByClick
   * @Description: 根据"用户"阅读量 查询最多的十篇 (按点击量排序)
   * @return List<Article>
   * @throws
   */
  public List<Article> findArticleByClick(int uid);
  
  /**  
   * @Title: findClickCount
   * @Description: 查询点击数
   * @return int
   * @throws
   */
  public int findClickCount(int id);
  
  /**  
   * @Title: findCommentCount
   * @Description: 查询评论数
   * @return int
   * @throws
   */
  public int findCommentCount(int id);
  
  /**  
   * @Title: findEnjoyCount
   * @Description: 查询喜欢数
   * @return int
   * @throws
   */
  public int findEnjoyCount(int id);
  
}
