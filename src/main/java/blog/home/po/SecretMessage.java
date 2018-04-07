package blog.home.po;

import java.util.Date;

import lombok.Data;

/**
 * @author Leihen
 * @date 2018年4月7日
 */
@Data
public class SecretMessage {
  private int id;
  private String content;
  private Date publish_time;
  private int user_id;
  private int getuser_id;
  private int state;

}
