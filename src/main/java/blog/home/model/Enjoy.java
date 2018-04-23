package blog.home.model;

import lombok.Data;

/**  
 * @ClassName: Enjoy  
 * @Description: 用户喜欢文章实体类
 * @author Leihen  
 * @date 2018年4月23日      
 */  
@Data
public class Enjoy {
  private int id;
  private int user_id;
  private int article_id;
  private UserInfo userInfo;//文章喜欢人的信息
}
