package blog.home.model;

import lombok.Data;

/**  
 * @ClassName: SysMessageUser  
 * @Description: 系统消息与用户关系实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */
@Data
public class MessageUser {
  private int id;
  private int recipientUid;
  private int messageId;
  private int is_sysMessage;
  private int state;
  private Message message;
}
