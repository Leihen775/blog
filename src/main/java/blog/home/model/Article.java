package blog.home.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


/**  
 * @ClassName: Article  
 * @Description: 博客文章实体类
 * @author Leihen  
 * @date 2018年4月20日      
 */  
@Data
public class Article {
  private int id;
  private int publishSort;
  private String title;
  private String content;
  private int category_id;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publish_time;
  private int clickCount;
  private int enjoyCount;
  private int commentCount;
  private int state;
  private int is_private;
  private int user_id;
  private Category category; //文章类别信息
  private UserInfo userInfo; //发布人信息
  private List<ArticleTag> articleTagList; //文章标签信息
  private List<Comment> commentList; //评论信息
  private List<Enjoy> enjoyList; //被喜欢信息
}
