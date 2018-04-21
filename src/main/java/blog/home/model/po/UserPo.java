package blog.home.model.po;

import blog.home.model.UserCore;
import blog.home.model.UserInfo;
import lombok.Data;

@Data
public class UserPo {
  private UserCore userCore;
  private UserInfo userInfo;
}
