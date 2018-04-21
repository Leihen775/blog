package blog.home.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


/**  
 * @ClassName: Article  
 * @Description: 博客文章实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class Article {
  private int id;
  private int publishSort;
  private String title;
  private String content;
  private int category_id;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publish_time;
  private int state;
  private int is_private;
  private int click_count;
  private int praise_count;
  private int user_id;

}
