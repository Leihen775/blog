package blog.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.ArticleMapper;
import blog.home.dao.EnjoyMapper;
import blog.home.dao.UserInfoMapper;
import blog.home.model.Enjoy;
import blog.home.service.IEnjoyService;

@Service
@Transactional
public class EnjoyServiceImpl implements IEnjoyService {
  
  @Autowired
  EnjoyMapper enjoyMapper;
  @Autowired
  ArticleMapper articleMapper;
  @Autowired
  UserInfoMapper userInfoMapper;

  @Override
  public void addEnjoy(Enjoy enjoy) {
    enjoyMapper.addEnjoy(enjoy);
    articleMapper.addEnjoyCount(enjoy.getArticle_id());
    userInfoMapper.addEnjoyCount(enjoy.getUser_id());
  }

  @Override
  public void deleteEnjoy(Enjoy enjoy) {
    enjoyMapper.deleteEnjoy(enjoy.getId());
    articleMapper.minusEnjoyCount(enjoy.getArticle_id());
    userInfoMapper.minusEnjoyCount(enjoy.getUser_id());
  }

  @Override
  public Enjoy findEnjoy(Enjoy enjoy) {
    return enjoyMapper.findEnjoy(enjoy);
  }

  @Override
  public int findCountByArticle(int aid) {
    return enjoyMapper.findCountByArticle(aid);
  }

  @Override
  public int findCountByUser(int uid) {
    return enjoyMapper.findCountByUser(uid);
  }

}
