package blog.home.po;

import lombok.Data;

/**  
 * @ClassName: ArticleTag  
 * @Description: 博客文章个人标签关系实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class ArticleTag {
  private int id;
  private int article_id;
  private int tag_id;
  
}
