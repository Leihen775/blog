package blog.home.model;

import lombok.Data;

/**  
 * @ClassName: Attention  
 * @Description: 用户关注实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class Attention {
  private int id;
  private int userId;
  private int attentionUid;
  private UserInfo userInfo; //用户信息
}
