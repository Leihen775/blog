package blog.home.dao;

import java.util.List;
import java.util.Set;

import blog.home.model.UserInfo;
import blog.home.model.UserRole;

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
   * @Title: addAttentionCount
   * @Description: 关注数+1
   * @return void
   * @throws
   */
  public void addAttentionCount(int id);

  /**  
   * @Title: addFansCount
   * @Description: 粉丝数+1
   * @return void
   * @throws
   */
  public void addFansCount(int id);

  /**  
   * @Title: addArticleCount
   * @Description: 文章数+1
   * @return void
   * @throws
   */
  public void addArticleCount(int id);

  /**  
   * @Title: addCommentCount
   * @Description: 评论数+1
   * @return void
   * @throws
   */
  public void addCommentCount(int id);

  /**  
   * @Title: addEnjoyCount
   * @Description: 喜欢数+1
   * @return void
   * @throws
   */
  public void addEnjoyCount(int id);
  
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
   * @Title: minusAttentionCount
   * @Description: 关注数-1
   * @return void
   * @throws
   */
  public void minusAttentionCount (int id);
  
  /**  
   * @Title: minusFansCount
   * @Description: 粉丝数-1
   * @return void
   * @throws
   */
  public void minusFansCount (int id);
  
  /**  
   * @Title: minusArticleCount
   * @Description: 文章数-1
   * @return void
   * @throws
   */
  public void minusArticleCount (int id);
  
  /**  
   * @Title: minusCommentCount
   * @Description: 评论数-1
   * @return void
   * @throws
   */
  public void minusCommentCount (int id);
  
  /**  
   * @Title: minusEnjoyCount
   * @Description: 喜欢数-1
   * @return void
   * @throws
   */
  public void minusEnjoyCount (int id);
  
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
  
  /**  
   * @Title: findAttentionCount
   * @Description: 查找关注数
   * @return int
   * @throws
   */
  public int findAttentionCount(int id);
  
  /**  
   * @Title: findFansCount
   * @Description: 查找粉丝数
   * @return int
   * @throws
   */
  public int findFansCount(int id);
  
  /**  
   * @Title: findArticleCount
   * @Description: 查找文章数
   * @return int
   * @throws
   */
  public int findArticleCount(int id);
  
  /**  
   * @Title: findCommentCount
   * @Description: 查找评论数
   * @return int
   * @throws
   */
  public int findCommentCount(int id);
  
  /**  
   * @Title: findEnjoyCount
   * @Description: 查找喜欢数
   * @return int
   * @throws
   */
  public int findEnjoyCount(int id);
  
  public void addUserRole(UserRole userRole);
  
  public void deleteUserRole(int urid);
  
  public void updateUserRole(UserRole UserRole);
  
  public Set<String> findRoles(String info);
  
  public Set<String> findPermissions(String info);
}
