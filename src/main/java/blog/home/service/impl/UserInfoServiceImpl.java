package blog.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.UserInfoMapper;
import blog.home.model.UserInfo;
import blog.home.service.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
  
  @Autowired
  UserInfoMapper userInfoMapper;

  @Override
  public void addUserInfo(UserInfo userInfo) {
    userInfoMapper.addUserInfo(userInfo);    
  }

  @Override
  public void updateUserInfo(UserInfo userInfo) {
    userInfoMapper.updateUserInfo(userInfo);
  }

  @Override
  public UserInfo findUser(int id) {
    return userInfoMapper.findUser(id);
  }

  @Override
  public UserInfo findUserByAccount(String inputInfo) {
    return userInfoMapper.findUserByInputInfo(inputInfo);
  }
  
}
