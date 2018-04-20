package blog.home.po;

import lombok.Data;

/**  
 * @ClassName: SysMessageUser  
 * @Description: 系统消息与用户关系实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */
@Data
public class SysMessageUser {
  private int id;
  private int user_id;
  private int message_id;
  private int state;
}
