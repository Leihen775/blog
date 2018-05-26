package blog.home.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**  
 * @ClassName: SysMessage  
 * @Description: 系统消息实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class Message {
  private int id;
  private String content;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publishTime;
  private int senderId;
  private int state;
  private UserInfo userInfo;
}
