package blog.home.model.po;

import java.util.List;

import blog.home.model.Article;
import blog.home.model.Category;
import lombok.Data;

@Data
public class ArticlePo {
  private Article article;
  private Category category;
  private List<ArticleTagPo> articleTagList;
  
}
