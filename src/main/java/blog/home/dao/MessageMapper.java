package blog.home.dao;

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
   * @Title: findMessage
   * @Description: 根据 信息ID 查询信息内容 
   * @return Message
   * @throws
   */
  public Message findMessage(int id);
  
}
