package blog.home.service;

import java.util.Set;

import blog.home.model.UserInfo;
import blog.home.model.UserRole;

public interface IUserInfoService {
  
  /**  
   * @Title: addUserInfo
   * @Description: 用户信息注册
   * @return void
   * @throws
   */
  public void addUserInfo(UserInfo userInfo);
  
  /**  
   * @Title: updateUserInfo
   * @Description: 修改用户信息
   * @return void
   * @throws
   */
  public void updateUserInfo(UserInfo userInfo);
  
  /**  
   * @Title: findUser
   * @Description: 根据Id查询用户信息 
   * @return UserInfo
   * @throws
   */
  public UserInfo findUser(int id);
  
  /**  
   * @Title: findUserByAccount
   * @Description: 根据账号或用户名查找用户简单信息 
   * @return UserInfo
   * @throws
   */
  public UserInfo findUserByInputInfo(String inputInfo);
  
  public void addUserRole(UserRole userRole);
  
  public void deleteUserRole(int urid);
  
  public void updateUserRole(UserRole UserRole);
  
  public Set<String> findRoles(String info);
  
  public Set<String> findPermissions(String info);

}
