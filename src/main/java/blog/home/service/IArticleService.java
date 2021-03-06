package blog.home.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import blog.home.model.Article;

public interface IArticleService {
  
  /**  
   * @Title: addArticle
   * @Description: 发布文章
   * @return void
   * @throws
   */
  public void addArticle(Article article,List<Integer> tagList);
  
  /**  
   * @Title: deleteArticle
   * @Description: 单个删除文章
   * @return void
   * @throws
   */
  public void deleteArticle(int aid);
  
  /**  
   * @Title: deleteArticleBatch
   * @Description: 批量删除文章
   * @return void
   * @throws
   */
  public void deleteArticleBatch(List<Integer> aidList);
  
  /**  
   * @Title: updateArticle
   * @Description: 修改文章
   * @return void
   * @throws
   */
  public void updateArticle(Article article,List<Integer> tagList);
  
  /**  
   * @Title: trashArticle
   * @Description: 使文章进回收站
   * @return void
   * @throws
   */
  public void trashArticle(Article article);
  
  /**  
   * @Title: findArticle
   * @Description: 根据ID查询文章信息
   * @return void
   * @throws
   */
  public Article findArticle(int id);
  
  /**  
   * @Title: findAllArticle
   * @Description: 查询所有文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findAllArticle(int pageNum,int pageSize);
  
  /**  
   * @Title: findArticleByCategory
   * @Description: 根据类别ID查询文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findArticleByCategory(int cid,int pageNum,int pageSize);
  
  /**  
   * @Title: findArticleByTitle
   * @Description: 根据 文章标题进行模糊查询 文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findArticleByTitle(String title,int pageNum);
  
  /**  
   * @Title: findArticleByUser
   * @Description: 根据“用户”ID查询文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findArticleByUser(int uid,int pageNum,int state);
  
  /**  
   * @Title: findArticlePublish
   * @Description: 根据用户ID查询所有已发布文章简略信息(按时间排序)
   * @return PageInfo<Article>
   * @throws
   */
//  public PageInfo<Article> findArticlePublish(int uid,int pageNum);
  
  /**  
   * @Title: findArticleDraft
   * @Description: 根据用户ID查询所有草稿文章简略信息(按时间排序)
   * @return PageInfo<Article>
   * @throws
   */
//  public PageInfo<Article> findArticleDraft(int uid,int pageNum);
  
  /**  
   * @Title: findArticleGarbage
   * @Description: 根据用户ID查询所有已删除文章简略信息(按时间排序)
   * @return PageInfo<Article>
   * @throws
   */
//  public PageInfo<Article> findArticleGarbage(int uid,int pageNum);
  
  /**  
   * @Title: findArticleCount
   * @Description: 根据用户ID查询所有个人标签,并根据“用户”标签ID查询相关文章数量
   * @return int
   * @throws
   */
  public Map<String,Integer> findArticleCountByTag(int uid);
  
  /**  
   * @Title: findArticleByCategory
   * @Description: 根据“用户”标签ID 查询文章简略信息
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findArticleByTag(int tid);
  
  /**  
   * @Title: findArticleByUserTitle
   * @Description: 根据 "用户"标题模糊查询文章简略信息(按时间排序)
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findArticleByUserTitle(Article Article);
  
  /**  
   * @Title: findArticleByClick
   * @Description: 根据 “用户”文章阅读量 查询最多的十篇
   * @return List<Article>
   * @throws
   */
  public PageInfo<Article> findArticleByClick(int uid);
  
}
