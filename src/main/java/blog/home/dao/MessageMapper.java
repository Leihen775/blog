package blog.home.dao;

import java.util.List;

import blog.home.model.Message;

/**  
 * @ClassName: MessageMapper  
 * @Description: 操作数据库sys_message信息内容表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface MessageMapper {
  
  /**  
   * @Title: addMessage
   * @Description: 添加信息
   * @return void
   * @throws
   */
  public void addMessage(Message message);
  
  /**  
   * @Title: deleteMessage
   * @Description: 发送者删除信息
   * @return void
   * @throws
   */
  public void deleteMessage(int id);
  
  /**  
   * @Title: deleteMessage
   * @Description: 发送者批量删除信息
   * @return void
   * @throws
   */
  public void deleteMessageBatch(List<Integer> idList);
  
  /**  
   * @Title: keepMessage
   * @Description: 保存信息为存稿
   * @return void
   * @throws
   */
  public void keepMessage(int id);
  
  /**  
   * @Title: sendMessage
   * @Description: 发送信息
   * @return void
   * @throws
   */
  public void sendMessage(int id);
  
  /**  
   * @Title: findDraft
   * @Description: 根据用户ID查询所有草稿
   * @return List<Message>
   * @throws
   */
  public List<Message> findDraft(int sender);
  
  /**  
   * @Title: findDraftDetail
   * @Description: 根据 草稿ID 查询草稿内容 
   * @return Message
   * @throws
   */
  public Message findDraftDetail(int id);
  
}
