package blog.home.model;

import lombok.Data;

/**  
 * @ClassName: Collect  
 * @Description: 博客文章收藏实体类 
 * @author Leihen  
 * @date 2018年4月20日      
 */
@Data
public class Collect {
  private int id;
  private String title;
  private String url;
  private int user_id;
  private int article_id;
}
