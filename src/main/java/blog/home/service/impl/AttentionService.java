package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.AttentionMapper;
import blog.home.model.Attention;

@Service
@Transactional
public class AttentionService implements blog.home.service.IAttentionService {
  
  @Autowired
  AttentionMapper attentionMapper;

  @Override
  public void addAttention(Attention attention) {
    attentionMapper.addAttention(attention);    
  }

  @Override
  public void deleteAttention(Attention attention) {
    attentionMapper.deleteAttention(attention);    
  }

  @Override
  public List<Attention> findAttentionByUser(int uid) {
    return attentionMapper.findAttentionByUser(uid);
  }

  @Override
  public int findAttentionCount(int uid) {
    return attentionMapper.findAttentionCount(uid);
  }

  @Override
  public List<Attention> findFansByAttention(int aid) {
    return attentionMapper.findFansByAttention(aid);
  }

  @Override
  public int findFansCount(int aid) {
    return attentionMapper.findFansCount(aid);
  }

}
