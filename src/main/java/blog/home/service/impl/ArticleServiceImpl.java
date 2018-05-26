package blog.home.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
    if(article.getState()==1) {
      userInfoMapper.addArticleCount(article.getUserId());
    }
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
  public PageInfo<Article> findAllArticle() {
    PageHelper.startPage(1, 3);
    PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.findAllArticle(),3);
    return pageInfo;
  }
  
  @Override
  public PageInfo<Article> findArticleByCategory(int cid) {
    PageHelper.startPage(1, 3);
    PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.findArticleByCategory(cid),3);
    return pageInfo;
  }
  
  @Override
  public PageInfo<Article> findArticleByTitle(String title) {
    PageHelper.startPage(1, 3);
    PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.findArticleByTitle(title),3);
    return pageInfo;
  }

  @Override
  public PageInfo<Article> findArticleByUser(int uid,int pageNum,int state) {
    PageHelper.startPage(pageNum,3);
    PageInfo<Article> pageInfo =new PageInfo<Article>();
    if(state==0) {
      pageInfo = new PageInfo<Article>(articleMapper.findArticleByUser(uid),3);
    }else if(state==1) {
      pageInfo = new PageInfo<Article>(articleMapper.findArticlePublish(uid),3);
    }else if(state==2) {
      pageInfo = new PageInfo<Article>(articleMapper.findArticleDraft(uid),3);
    }else {
      pageInfo = new PageInfo<Article>(articleMapper.findArticleGarbage(uid),3);
    }
    return pageInfo;
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
  public PageInfo<Article> findArticleByTag(int tid) {
    PageHelper.startPage(1, 3);
    PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.findArticleByTag(tid),3);
    return pageInfo;
  }
  
  @Override
  public PageInfo<Article> findArticleByUserTitle(Article Article) {
    PageHelper.startPage(1, 3);
    PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.findArticleByUserTitle(Article),3);
    return pageInfo;
  }

  @Override
  public PageInfo<Article> findArticleByClick(int uid) {
    PageHelper.startPage(1, 3);
    PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.findArticleByClick(uid),3);
    return pageInfo;
  }

}
