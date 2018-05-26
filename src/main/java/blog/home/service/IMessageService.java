package blog.home.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.home.model.Message;
import blog.home.model.MessageUser;

public interface IMessageService {
  
  /**  
   * @Title: keepSecretMessage
   * @Description: 保存信息为存稿
   * @return void
   * @throws
   */
  public void keepMessage(Message message);
  
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
   * @Title: deleteAllMessage
   * @Description: 根据收信人ID删除所有信息
   * @return void
   * @throws
   */
  public void deleteAllMessage(int uid);
  
  /**  
   * @Title: AllMessageRead
   * @Description: 根据用户ID 把信息全部标记为已读
   * @return void
   * @throws
   */
  public void AllMessageRead(int uid);
  /**  
   * @Title: MessageRead
   * @Description: 根据信息详情ID 把信息标记为已读
   * @return void
   * @throws
   */
  public void MessageRead(int id);
  
  /**  
   * @Title: findMessage
   * @Description: 查询信息内容 
   * @return Message
   * @throws
   */
  public MessageUser findMessage(int id);
  
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
   * @Description: 根据 收信人ID 查询所有系统通知
   * @return PageInfo<MessageUser>
   * @throws
   */
  public PageInfo<MessageUser> findSysMessage(int uid,int pageNum);
  
  /**  
   * @Title: findSysMessageRead
   * @Description: 根据 收信人ID 查询已读系统通知
   * @return PageInfo<MessageUser>
   * @throws
   */
  public PageInfo<MessageUser> findSysMessageRead(int uid);
  
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
  
  /**  
   * @Title: findDraft
   * @Description: 根据用户查找草稿
   * @return PageInfo<Message>
   * @throws
   */
  public PageInfo<Message> findDraft(int sender);
  
  /**  
   * @Title: findDraftDetail
   * @Description: 根据草稿ID查找草稿详情
   * @return Message
   * @throws
   */
  public Message findDraftDetail(int id);

}
