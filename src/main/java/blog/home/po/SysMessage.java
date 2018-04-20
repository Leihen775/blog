package blog.home.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**  
 * @ClassName: SysMessage  
 * @Description: 系统消息实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class SysMessage {
  private int id;
  private String content;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publish_time;
  
}
