package blog.home.dao;

import java.util.List;

import blog.home.model.Attention;
import blog.home.model.SecretMessage;

/**  
 * @ClassName: SecretMessageMapper  
 * @Description: 操作数据库user_secretmessage用户私信表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface SecretMessageMapper {
  
  /**  
   * @Title: addSecretMessage
   * @Description: 发送私信信息
   * @return void
   * @throws
   */
  public void addSecretMessage(SecretMessage secretMessage);
  
  /**  
   * @Title: deleteRecMessage
   * @Description: 删除收信人私信
   * @return void
   * @throws
   */
  public void deleteRecMessage(int id);
  
  /**  
   * @Title: deleteRecMessageBatch
   * @Description: 批量删除收信人私信
   * @return void
   * @throws
   */
  public void deleteRecMessageBatch(List<Integer> idList);
  
  /**  
   * @Title: deleteSenderMessage
   * @Description: 删除发信人私信
   * @return void
   * @throws
   */
  public void deleteSenderMessage(int id);
  
  /**  
   * @Title: deleteSenderMessageBatch
   * @Description: 批量删除发信人私信
   * @return void
   * @throws
   */
  public void deleteSenderMessageBatch(List<Integer> idList);
  
  /**  
   * @Title: updateSenderState
   * @Description: 修改收信人私信存在状态
   * @return void
   * @throws
   */
  public void updateSenderState(int id);
  
  /**  
   * @Title: updateRecState
   * @Description: 修改发信人私信存在状态
   * @return void
   * @throws
   */
  public void updateRecState(int id);
  
  /**  
   * @Title: findMessage
   * @Description: 根据 私信ID 查询私信信息 
   * @return SecretMessage
   * @throws
   */
  public SecretMessage findMessage(int id);
  
  /**  
   * @Title: findCountByAttention
   * @Description: 根据 关注信息 查询关注人所发未读私信数量
   * @return int
   * @throws
   */
  public int findCountByAttention(List<Attention> list);
  
  /**  
   * @Title: findCount
   * @Description: 根据 关注信息 查询未关注人所发未读私信数量
   * @return int
   * @throws
   */
  public int findCount(List<Attention> list);
  
  /**  
   * @Title: findMessageByAttention
   * @Description: 根据 关注信息 查询关注人所发私信
   * @return TODO
   * @throws
   */
  public void findMessageByAttention(List<Attention> list);
  
  /**  
   * @Title: findMessage
   * @Description: 根据 关注信息 查询未关注人所发私信
   * @return void
   * @throws
   */
  public void findMessage(List<Attention> list);
  
}
