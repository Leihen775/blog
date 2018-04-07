package blog.home.po;

import java.util.Date;

import lombok.Data;

/**
 * @author Leihen
 * @date 2018年4月7日
 */
@Data
public class UserInfoDetail {
  private int id;
  private int user_id;
  private String realname;
  private String job;
  private int sex;
  private Date birth;
  private int trade_id;
  private String adress;
  private String email;
  private String summary;
  private String image_path;
  private int is_private;

}
