package blog.home.service;

import java.util.List;

import blog.home.model.Article;

public interface ArticleService {
  
  /**  
   * @Title: addArticle
   * @Description: 发布文章
   * @return void
   * @throws
   */
  public void addArticle(Article article,List<Integer> list);
  
  /**  
   * @Title: deleteArticle
   * @Description: 删除文章
   * @return void
   * @throws
   */
  public void deleteArticle(int aid);
  
}
