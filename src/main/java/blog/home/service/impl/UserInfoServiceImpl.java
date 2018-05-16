package blog.home.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.UserInfoMapper;
import blog.home.model.UserInfo;
import blog.home.model.UserRole;
import blog.home.service.IUserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
  
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
  public UserInfo findUserByInputInfo(String inputInfo) {
    return userInfoMapper.findUserByInputInfo(inputInfo);
  }

  @Override
  public void addUserRole(UserRole userRole) {
    userInfoMapper.addUserRole(userRole);
  }

  @Override
  public void deleteUserRole(int urid) {
    userInfoMapper.deleteUserRole(urid);
  }

  @Override
  public void updateUserRole(UserRole UserRole) {
    userInfoMapper.updateUserRole(UserRole);
  }

  @Override
  public Set<String> findRoles(String info) {
    return userInfoMapper.findRoles(info);
  }

  @Override
  public Set<String> findPermissions(String info) {
    return userInfoMapper.findPermissions(info);
  }
  
}
