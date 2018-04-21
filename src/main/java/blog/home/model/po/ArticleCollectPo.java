package blog.home.model.po;

import blog.home.model.Collect;
import lombok.Data;

@Data
public class ArticleCollectPo {
  private Collect collect;
  private ArticlePo article;

}
