package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.EnjoyMapper;
import blog.home.model.Enjoy;
import blog.home.service.IEnjoyService;

@Service
@Transactional
public class EnjoyServiceImpl implements IEnjoyService {
  
  @Autowired
  EnjoyMapper enjoyMapper;

  @Override
  public void addEnjoy(Enjoy enjoy) {
    enjoyMapper.addEnjoy(enjoy);
  }

  @Override
  public void deleteEnjoy(Enjoy enjoy) {
    enjoyMapper.deleteEnjoy(enjoy);
  }

  @Override
  public List<Enjoy> findEnjoyByArticle(int aid) {
    return enjoyMapper.findEnjoyByArticle(aid);
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
