package blog.home.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**  
 * @ClassName: Comment  
 * @Description: 博客文章评论实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class Comment {
  private int id;
  private String content;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publish_time;
  private int article_id;
  private int user_id;
  private int getuser_id;
  private int pid;
  
}
