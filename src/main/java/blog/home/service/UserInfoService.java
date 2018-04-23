package blog.home.service;

import blog.home.model.UserInfo;

public interface UserInfoService {
  
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
  public UserInfo findUserByAccount(String accountNum);

}
