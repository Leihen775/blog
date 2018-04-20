package blog.home.dao;

import blog.home.po.SecretMessage;

/**  
 * @ClassName: SecretMessageMapper  
 * @Description: 操作数据库user_secretmessage用户私信表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface SecretMessageMapper {
  
  /**  
   * @Title: addSecretMessage
   * @Description: 添加私信信息
   * @return void
   * @throws
   */
  public void addSecretMessage(SecretMessage secretMessage);
  
  /**  
   * @Title: updateState
   * @Description: 收信人修改私信状态
   * @return void
   * @throws
   */
  public void updateState(SecretMessage secretMessage);
  
  public void deleteUserId(int id);
  
}
