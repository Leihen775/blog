package blog.home.model;

import lombok.Data;

/**  
 * @ClassName: UserCore  
 * @Description: 用户核心信息实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class UserCore {
  private int id;
  private String accountnum;
  private String username;
  private String password;
  
}
