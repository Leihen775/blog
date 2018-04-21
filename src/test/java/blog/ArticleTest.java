package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Article;
import blog.home.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})     
public class ArticleTest {
  
  @Autowired
  private ArticleService articleService;
  
  @Test
  public void addTest() {
    Article article = new Article();
    List<Integer> list = new ArrayList<Integer>();
    article.setTitle("第三条数据");
    article.setContent("这是添加的第三条测试数据");
    article.setPublish_time(new Date());
    list.add(3);
    list.add(4);
    
    articleService.addArticle(article, list);
  }
  
  @Test
  public void deleteTest() {
    int id = 2;
    articleService.deleteArticle(id);
  }
  
}
