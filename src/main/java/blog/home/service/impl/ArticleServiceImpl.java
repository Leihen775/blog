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
import blog.home.dao.CommentMapper;
import blog.home.dao.TagMapper;
import blog.home.dao.UserInfoMapper;
import blog.home.model.Article;
import blog.home.model.ArticleTag;
import blog.home.model.Tag;
import blog.home.service.IArticleService;

/**  
 * @ClassName: ArticleServiceImpl  
 * @Description:   
 * @author Leihen  
 * @date 2018年4月21日      
 */  
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {
  
  @Autowired
  ArticleMapper articleMapper;
  @Autowired
  ArticleTagMapper articleTagMapper;
  @Autowired
  TagMapper tagMapper;
  @Autowired
  UserInfoMapper userInfoMapper;
  @Autowired
  CommentMapper commentMapper;

  @Override
  public void addArticle(Article article, List<Integer> tagList) {
    articleMapper.addArticle(article);//添加文章信息
    Integer aid = article.getId();
    List<ArticleTag> articleTagList = new ArrayList<ArticleTag>();
    for(int i=0;i<tagList.size();i++) {
      ArticleTag articleTag = new ArticleTag();
      articleTag.setArticleId(aid);
      articleTag.setTagId(tagList.get(i));
      articleTagList.add(articleTag);
    }
    articleTagMapper.addArticleTag(articleTagList);//添加文章个人标签信息
    userInfoMapper.addArticleCount(article.getUserId());
  }
  
  @Override
  public void deleteArticle(int aid) {
    articleMapper.deleteArticle(aid);
    articleTagMapper.deleteByAid(aid);
    commentMapper.deleteCommentByArticle(aid);
  }

  @Override
  public void deleteArticleBatch(List<Integer> aidList) {
    articleMapper.deleteArticleBatch(aidList);
    articleTagMapper.deleteByAidBatch(aidList);
    commentMapper.deleteCommentByAidBatch(aidList);
  }

  @Override
  public void updateArticle(Article article,List<Integer> tagList) {
    articleMapper.updateArticle(article);
    articleTagMapper.deleteByAid(article.getId());
    List<ArticleTag> articleTagList = new ArrayList<ArticleTag>();
    for(int i=0;i<tagList.size();i++) {
      ArticleTag articleTag = new ArticleTag();
      articleTag.setArticleId(article.getId());
      articleTag.setTagId(tagList.get(i));
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
