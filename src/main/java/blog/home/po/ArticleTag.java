package blog.home.po;

import lombok.Data;

/**
 * @author Leihen
 * @date 2018年4月7日
 */
@Data
public class ArticleTag {
  private int id;
  private int article_id;
  private int tag_id;

}
