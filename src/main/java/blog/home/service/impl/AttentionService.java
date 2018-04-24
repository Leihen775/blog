package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.AttentionMapper;
import blog.home.dao.UserInfoMapper;
import blog.home.model.Attention;

@Service
@Transactional
public class AttentionService implements blog.home.service.IAttentionService {
  
  @Autowired
  AttentionMapper attentionMapper;
  @Autowired
  UserInfoMapper userInfoMapper;

  @Override
  public void addAttention(Attention attention) {
    attentionMapper.addAttention(attention);
    userInfoMapper.addAttentionCount(attention.getUserId());
    userInfoMapper.addFansCount(attention.getAttentionUid());
  }

  @Override
  public void deleteAttention(Attention attention) {
    attentionMapper.deleteAttention(attention.getId());
    userInfoMapper.minusAttentionCount(attention.getUserId());
    userInfoMapper.minusFansCount(attention.getAttentionUid());
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
  public Attention findFans(Attention attention) {
    return attentionMapper.findFans(attention);
  }

  @Override
  public int findFansCount(int aid) {
    return attentionMapper.findFansCount(aid);
  }

}
