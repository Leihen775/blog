package blog.home.dao;

import java.util.List;

import blog.home.model.UserInfo;

/**  
 * @ClassName: UserInfoDetail  
 * @Description: 操作数据库user_info用户信息表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface UserInfoMapper {
  
  /**  
   * @Title: addUserInfo
   * @Description: 添加用户详细信息
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
   * @Title: updateUserTrade
   * @Description: 修改用户行业信息(当用户行业被删除时使用)
   * @return void
   * @throws
   */
  public void updateUserTrade(int tid);
  
  /**  
   * @Title: updateUserTradeBatch
   * @Description: 修改用户行业信息(当用户行业被批量删除时使用)
   * @return void
   * @throws
   */
  public void updateUserTradeBatch(List<Integer> tidList);
  
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
  
}
