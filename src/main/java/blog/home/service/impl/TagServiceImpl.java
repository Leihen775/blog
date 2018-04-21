package blog.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.ArticleMapper;
import blog.home.dao.TagMapper;
import blog.home.model.Tag;
import blog.home.service.TagService;

@Service
@Transactional
public class TagServiceImpl implements TagService {
  
  @Autowired
  TagMapper tagMapper;
  @Autowired
  ArticleMapper articleMapper;

  @Override
  public void addTag(Tag tag) {
    
    tagMapper.addTag(tag);

  }

  @Override
  public void deleteTag(int id) {
    
    List<Integer> tidList = new ArrayList<Integer>();
    tidList.add(id);
    tagMapper.deleteTag(id);
    articleMapper.deleteArticleTagByTid(tidList);
    
  }

  @Override
  public void deleteTagBatch(List<Integer> idList) {
    
    tagMapper.deleteTagBatch(idList);
    articleMapper.deleteArticleTagByTid(idList);

  }

  @Override
  public void updateTag(Tag tag) {

    tagMapper.updateTag(tag);
    
  }

  @Override
  public List<Tag> findTagByUser(int user_id) {
    
    return tagMapper.findAllTag(user_id);
    
  }

  @Override
  public Tag findTagById(int id) {
    
    return tagMapper.findTagById(id);
    
  }

}
