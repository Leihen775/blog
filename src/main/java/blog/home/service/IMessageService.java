package blog.home.service;

import java.util.List;

import blog.home.model.Message;
import blog.home.model.MessageUser;

public interface IMessageService {
  
  /**  
   * @Title: sendSecretMessage
   * @Description: 发送私信
   * @return void
   * @throws
   */
  public void sendSecretMessage(Message message,int uid);
  
  /**  
   * @Title: sendSysMessage
   * @Description: 单次发送系统通知
   * @return void
   * @throws
   */
  public void sendSysMessage(Message message,int uid);
  
  /**  
   * @Title: sendSysMessageBatch
   * @Description: 批量发送系统通知
   * @return void
   * @throws
   */
  public void sendSysMessageBatch(Message message,List<Integer> uidList);
  
  /**  
   * @Title: deleteSenderMessage
   * @Description: 根据信息内容ID删除发信人所发信息
   * @return void
   * @throws
   */
  public void deleteSenderMessage(int id);
  
  /**  
   * @Title: deleteRecipientMessage
   * @Description: 根据信息详情ID删除收信人所收信息
   * @return void
   * @throws
   */
  public void deleteRecipientMessage(int id);
  
  /**  
   * @Title: updateRecipientMessage
   * @Description: 根据信息详情ID修改信息状态为已读
   * @return void
   * @throws
   */
  public void updateRecipientMessage(int id);
  
  /**  
   * @Title: findMessage
   * @Description: 根据 信息内容ID 查询信息内容 
   * @return Message
   * @throws
   */
  public Message findMessage(int id);
  
  /**  
   * @Title: findSecretMessage
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
