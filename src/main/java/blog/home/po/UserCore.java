package blog.home.po;

import lombok.Data;

/**
 * @author Leihen
 * @date 2018年4月7日
 */
@Data
public class UserCore {
  private int id;
  private String accountnum;
  private String username;
  private String password;
  private String rank_id;
  private String infodetail_id;
}
