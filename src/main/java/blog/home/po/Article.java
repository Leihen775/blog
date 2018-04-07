package blog.home.po;

import java.util.Date;

import lombok.Data;

/**
 * @author Leihen
 * @date 2018年4月7日
 */
@Data
public class Article {
  private int id;
  private int publishSort;
  private String title;
  private String content;
  private int category_id;
  private Date publish_time;
  private int state;
  private int is_private;
  private int click_count;
  private int praise_count;
  private int user_id;

}
