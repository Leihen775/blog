package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.CollectMapper;
import blog.home.model.Collect;
import blog.home.service.ICollectService;

@Service
@Transactional
public class CollectServiceImpl implements ICollectService {
  
  @Autowired
  CollectMapper collectMapper;

  @Override
  public void addCollect(Collect collect) {
    collectMapper.addCollect(collect);
  }

  @Override
  public void deleteCollect(int cid) {
    collectMapper.deleteCollect(cid);    
  }

  @Override
  public void deleteCollectBatch(List<Integer> cidList) {
    collectMapper.deleteCollectBatch(cidList);    
  }

  @Override
  public void updateCollect(Collect collect) {
    collectMapper.updateCollect(collect);    
  }

  @Override
  public List<Collect> findCollectByUser(int uid) {
    return collectMapper.findCollectByUser(uid);
  }

  @Override
  public int findCountByUser(int uid) {
    return collectMapper.findCountByUser(uid);
  }

  @Override
  public Collect findCollectById(int cid) {
    return collectMapper.findCollectById(cid);
  }

}
