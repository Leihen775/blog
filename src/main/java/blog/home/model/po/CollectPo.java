package blog.home.model.po;

import java.util.List;

import lombok.Data;

@Data
public class CollectPo {
  private UserPo user;
  private List<ArticleCollectPo> articlCollectList;

}
