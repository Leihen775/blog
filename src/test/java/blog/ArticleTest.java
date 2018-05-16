package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Article;
import blog.home.service.IArticleService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ArticleTest {
  
  @Autowired
  private IArticleService articleService;
  
  @Test
  public void addTest() {
    Article article = new Article();
    List<Integer> list = new ArrayList<Integer>();
    article.setTitle("第三条数据");
    article.setContent("这是添加的第三条测试数据");
    article.setPublishTime(new Date());
    list.add(3);
    list.add(4);
    
    articleService.addArticle(article, list);
  }
  
  @Test
  public void deleteTest() {
    List<Integer> id = new ArrayList<Integer>();
    id.add(2);
    articleService.deleteArticleBatch(id);
  }
  
  @Test
  public void updateTest() {
    Article article = articleService.findArticle(23);
    int clickCount = article.getClickCount();
    clickCount++;
    Article updatearticle = new Article();
    updatearticle.setId(23);
    updatearticle.setClickCount(clickCount);
    List<Integer> tagList = new ArrayList<Integer>();
    tagList.add(2);
    tagList.add(3);
    articleService.updateArticle(updatearticle, tagList);
  }
  
  @Test
  public void findTest() {
    Article article = articleService.findArticle(18);
    System.out.println(article);
  }
  
  @Test
  public void findTest2() {
    Map<String,Integer> map = articleService.findArticleCountByTag(1);
    for(String s:map.keySet()){
      System.out.println("key : "+s+" value : "+map.get(s));
    }
  }
  
  @Test
  public void findTest3() {
    List<Article> list = articleService.findArticleByClick(0);
    for (Article a:list) {
      System.out.println(a);
    }
  }
  
  @Test
  public void findTest4() {
    List<Article> list = articleService.findArticleByTag(3);
    for (Article a:list) {
      System.out.println(a);
    }
  }
  
  @Test
  public void findTest5() {
    List<Article> list = articleService.findAllArticle();
    for (Article a:list) {
      System.out.println(a);
    }
  }
  
  @Test
  public void findTest6() {
    List<Article> list = articleService.findArticleByCategory(2);
    for (Article a:list) {
      System.out.println(a);
    }
  }
  
  //用来测试的算出密码password盐值加密后的结果，下面方法用于新增用户添加到数据库操作的，我这里就直接用main获得，直接数据库添加了，省时间
  @Test
  public void ddt() {
       String hashAlgorithmName = "MD5";
       ByteSource salt=ByteSource.Util.bytes("3309");
       System.out.println(salt);
       String credentials = "01";
       int hashIterations = 1024;            
       Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
       System.out.println(result);
   }
}
