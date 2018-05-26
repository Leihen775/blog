package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.home.dao.ArticleTagMapper;
import blog.home.dao.TagMapper;
import blog.home.model.Tag;
import blog.home.service.ITagService;

@Service
@Transactional
public class TagServiceImpl implements ITagService {
  
  @Autowired
  TagMapper tagMapper;
  @Autowired
  ArticleTagMapper articleTagMapper;

  @Override
  public void addTag(Tag tag) {
    tagMapper.addTag(tag);
  }

  @Override
  public void deleteTag(int id) {
    tagMapper.deleteTag(id);
    articleTagMapper.deleteByTid(id);
  }

  @Override
  public void deleteTagBatch(List<Integer> idList) {
    tagMapper.deleteTagBatch(idList);
    articleTagMapper.deleteByTidBatch(idList);
  }

  @Override
  public void updateTag(Tag tag) {
    tagMapper.updateTag(tag);
  }

  @Override
  public List<Tag> findAllTagByUser(int uid) {
    return tagMapper.findAllTag(uid);
  }
  
  @Override
  public PageInfo<Tag> findTagByUser(int uid,int pageNum) {
    PageHelper.startPage(pageNum,3);
    PageInfo<Tag> pageInfo = new PageInfo<Tag>(tagMapper.findTagList(uid),3);
    return pageInfo;
  }

  @Override
  public Tag findTagById(int id) {
    return tagMapper.findTagById(id);
  }

}
