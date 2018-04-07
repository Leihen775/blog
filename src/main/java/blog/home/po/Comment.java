package blog.home.po;

import java.util.Date;

import lombok.Data;

/**
 * @author Leihen
 * @date 2018年4月7日
 */
@Data
public class Comment {
  private int id;
  private String content;
  private Date publish_time;
  private int article_id;
  private int user_id;
  private int getuser_id;
  private int pid;

}
