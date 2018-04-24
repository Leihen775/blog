package blog.home.model;

import java.util.Date;
import java.util.List;

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
  private String accountNum;
  private String username;
  private String password;
  private String realname;
  private String job;
  private int sex;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date birth;
  private int tradeId;
  private String address;
  private String email;
  private String summary;
  private String imagePath;
  private int birth_private;
  private int realname_private;
  private int address_private;
  private int attentionCount;
  private int fansCount;
  private int articleCount;
  private int commentCount;
  private int enjoyCount;
  private Trade trade; //用户行业信息
  private List<Attention> attentionList; //用户关注信息
  private List<Collect> collectList; //用户收藏信息
}
