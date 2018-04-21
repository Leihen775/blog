package blog.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.ArticleMapper;
import blog.home.model.Article;
import blog.home.model.ArticleTag;
import blog.home.service.ArticleService;

/**  
 * @ClassName: ArticleServiceImpl  
 * @Description:   
 * @author Leihen  
 * @date 2018年4月21日      
 */  
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
  
  @Autowired
  ArticleMapper articleMapper;

  @Override
  public void addArticle(Article article, List<Integer> list) {

    articleMapper.addArticle(article);//添加文章信息
    Integer article_id = article.getId();
    List<ArticleTag> articleTagList = new ArrayList<ArticleTag>();
    for(int i=0;i<list.size();i++) {
      ArticleTag articleTag = new ArticleTag();
      articleTag.setArticle_id(article_id);
      articleTag.setTag_id(list.get(i));
      articleTagList.add(articleTag);
    }
    int[] arr= new int[2];
    arr[3] = 1;//抛出异常，事务回滚
    articleMapper.addArticleTag(articleTagList);//添加文章个人标签信息

  }

  @Override
  public void deleteArticle(int aid) {

    articleMapper.deleteArticle(aid);
    int[] arr= new int[2];
    arr[3] = 1;//抛出异常，事务回滚
    articleMapper.deleteArticleTag(aid);
    
  }

}
