package blog.home.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.ArticleMapper;
import blog.home.dao.ArticleTagMapper;
import blog.home.dao.TagMapper;
import blog.home.model.Article;
import blog.home.model.ArticleTag;
import blog.home.model.Tag;
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
  @Autowired
  ArticleTagMapper articleTagMapper;
  @Autowired
  TagMapper tagMapper;

  @Override
  public void addArticle(Article article, List<Integer> tagList) {
    articleMapper.addArticle(article);//添加文章信息
    Integer aid = article.getId();
    List<ArticleTag> articleTagList = new ArrayList<ArticleTag>();
    for(int i=0;i<tagList.size();i++) {
      ArticleTag articleTag = new ArticleTag();
      articleTag.setArticle_id(aid);
      articleTag.setTag_id(tagList.get(i));
      articleTagList.add(articleTag);
    }
    int[] arr= new int[2];
    arr[3] = 1;//抛出异常，事务回滚
    articleTagMapper.addArticleTag(articleTagList);//添加文章个人标签信息
  }
  
  @Override
  public void deleteArticle(int aid) {
    articleMapper.deleteArticle(aid);
    int[] arr= new int[2];
    arr[3] = 1;//抛出异常，事务回滚
    articleTagMapper.deleteByAid(aid);
  }

  @Override
  public void deleteArticleBatch(List<Integer> aidList) {
    articleMapper.deleteArticleBatch(aidList);
    int[] arr= new int[2];
    arr[3] = 1;//抛出异常，事务回滚
    articleTagMapper.deleteByAidBatch(aidList);
  }

  @Override
  public void updateArticle(Article article,List<Integer> tagList) {
    articleMapper.updateArticle(article);
    articleTagMapper.deleteByAid(article.getId());
    List<ArticleTag> articleTagList = new ArrayList<ArticleTag>();
    for(int i=0;i<tagList.size();i++) {
      ArticleTag articleTag = new ArticleTag();
      articleTag.setArticle_id(article.getId());
      articleTag.setTag_id(tagList.get(i));
      articleTagList.add(articleTag);
    }
    articleTagMapper.addArticleTag(articleTagList);
  }

  @Override
  public Article findArticle(int id) {
    return articleMapper.findArticle(id);
  }

  @Override
  public List<Article> findAllArticle() {
    return articleMapper.findAllArticle();
  }
  
  @Override
  public List<Article> findArticleByCategory(int cid) {
    return articleMapper.findArticleByCategory(cid);
  }
  
  @Override
  public List<Article> findArticleByTitle(String title) {
    return articleMapper.findArticleByTitle(title);
  }

  @Override
  public List<Article> findArticleByUser(int uid) {
    return articleMapper.findArticleByUser(uid);
  }

  @Override
  public Map<String, Integer> findArticleCountByTag(int uid) {
    List<Tag> tagList = tagMapper.findAllTag(uid);
    Map<String,Integer> map = new HashMap<String,Integer>();
    for(Tag tag:tagList) {
      int count = articleMapper.findArticleCountByTag(tag.getId());
      map.put(tag.getTag(), count);
    }
    return map;
  }
  
  @Override
  public List<Article> findArticleByTag(int tid) {
    return articleMapper.findArticleByTag(tid);
  }
  
  @Override
  public List<Article> findArticleByUserTitle(Article Article) {
    return articleMapper.findArticleByUserTitle(Article);
  }

  @Override
  public List<Article> findArticleByClick(int uid) {
    return articleMapper.findArticleByClick(uid);
  }

}
