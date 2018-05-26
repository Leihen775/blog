package blog.home.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
  private int type;
  private String title;
  private String content;
  private int categoryId;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publishTime;
  private int clickCount;
  private int enjoyCount;
  private int commentCount;
  private int state;
  private int is_private;
  private int userId;
  private Category category; //文章类别信息
  private UserInfo userInfo; //发布人信息
  private List<ArticleTag> articleTagList; //文章标签信息
}
