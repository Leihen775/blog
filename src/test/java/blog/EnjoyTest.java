package blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Enjoy;
import blog.home.service.IEnjoyService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class EnjoyTest {
  
  @Autowired
  IEnjoyService enjoyServiceImpl;
  
  @Test
  public void add() {
    Enjoy enjoy = new Enjoy();
    enjoy.setUserId(4);
    enjoy.setArticleId(16);
    enjoyServiceImpl.addEnjoy(enjoy);
   }
  
  @Test 
  public void delete() {
    Enjoy enjoy = new Enjoy();
    enjoy.setUserId(1);
    enjoy.setArticleId(15);
    enjoy=enjoyServiceImpl.findEnjoy(enjoy);
    enjoyServiceImpl.deleteEnjoy(enjoy);
  }
  
  @Test
  public void find() {
    int count = enjoyServiceImpl.findCountByArticle(16);
    System.out.println(count);
  }
  
  @Test
  public void find2() {
    int count = enjoyServiceImpl.findCountByUser(3);
    System.out.println(count);
  }

}
