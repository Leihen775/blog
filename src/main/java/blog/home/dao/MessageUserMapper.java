package blog.home.dao;

import java.util.List;

import blog.home.model.MessageUser;

/**  
 * @ClassName: MessageUserMapper  
 * @Description: 操作数据库sys_message_user信息与用户关系表
 * @author Leihen  
 * @date 2018年4月23日      
 */  
public interface MessageUserMapper {
  
  /**  
   * @Title: addSecretMessage
   * @Description: 发送私信
   * @return void
   * @throws
   */
  public void addSecretMessage(MessageUser messageUser);

  /**  
   * @Title: addSysMessage
   * @Description: 单次发送系统通知
   * @return void
   * @throws
   */
  public void addSysMessage(MessageUser messageUser);
  
  /**  
   * @Title: addSysMessageBatch
   * @Description: 批量发送系统通知
   * @return void
   * @throws
   */
  public void addSysMessageBatch(List<MessageUser> messageUserList);
  
  /**  
   * @Title: deleteMessage
   * @Description: 用户删除信息
   * @return void
   * @throws
   */
  public void deleteMessage(int id);
  
  /**  
   * @Title: deleteAllMessage
   * @Description: 用户删除所有信息
   * @return void
   * @throws
   */
  public void deleteAllMessage(int uid);
  
  /**  
   * @Title: updateMessage
   * @Description: 修改信息为已读
   * @return void
   * @throws
   */
  public void updateMessageRead(int id);
  
  /**  
   * @Title: updateAllMessageRead
   * @Description: 修改全部信息为已读
   * @return void
   * @throws
   */
  public void updateAllMessageRead(int uid);
  
  /**  
   * @Title: findMessage
   * @Description: 查看信息
   * @return MessageUser
   * @throws
   */
  public MessageUser findMessage(int id);
  
  /**  
   * @Title: findMessage
   * @Description: 根据 收信人ID 查询未读私信
   * @return List<MessageUser>
   * @throws
   */
  public List<MessageUser> findSecretMessage(int uid);
  
  /**  
   * @Title: findSecretMessageRead
   * @Description: 根据 收信人ID 查询已读私信
   * @return List<MessageUser>
   * @throws
   */
  public List<MessageUser> findSecretMessageRead(int uid);
  
  /**  
   * @Title: findSysMessage
   * @Description: 根据 收信人ID 查询未读系统通知
   * @return List<MessageUser>
   * @throws
   */
  public List<MessageUser> findSysMessage(int uid);
  
  /**  
   * @Title: findSysMessageRead
   * @Description: 根据 收信人ID 查询已读系统通知
   * @return List<MessageUser>
   * @throws
   */
  public List<MessageUser> findSysMessageRead(int uid);
  
  /**  
   * @Title: findCount
   * @Description: 根据 收信人ID 查询未读消息数量
   * @return int
   * @throws
   */
  public int findCount(int uid);
  
  /**  
   * @Title: findSecretCount
   * @Description: 根据 收信人ID 查询未读私信数量
   * @return int
   * @throws
   */
  public int findSecretCount(int uid);
  
  /**  
   * @Title: findSysCount
   * @Description: 根据 收信人ID 查询未读通知数量
   * @return int
   * @throws
   */
  public int findSysCount(int uid);
  
}
