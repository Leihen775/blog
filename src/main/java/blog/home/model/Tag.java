package blog.home.model;

import lombok.Data;

/**  
 * @ClassName: Tag  
 * @Description: 个人标签实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class Tag {
  private int id;
  private String tag;
  private int user_id;
  
}
