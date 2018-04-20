package blog.home.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**  
 * @ClassName: SecretMessage  
 * @Description: 用户私信实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class SecretMessage {
  private int id;
  private String content;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publish_time;
  private int user_id;
  private int getuser_id;
  private int state;
  
}
