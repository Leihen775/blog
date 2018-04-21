package blog.home.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**  
 * @ClassName: UserInfoDetail  
 * @Description: 用户详细信息实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class UserInfo {
  private int id;
  private int user_id;
  private String realname;
  private String job;
  private int sex;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date birth;
  private int trade_id;
  private String adress;
  private String email;
  private String summary;
  private String image_path;
  private int is_private;
  
}
