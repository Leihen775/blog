package blog;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Attention;
import blog.home.service.IAttentionService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})     
public class AttentionTest {
  
  @Autowired
  IAttentionService attentionService;
  
  @Test
  public void add() {
    Attention a = new Attention();
    a.setUserId(2);
    a.setAttentionUid(8);
    attentionService.addAttention(a);
  }
  
  @Test
  public void delete() {
    Attention a = new Attention();
    a.setUserId(2);
    a.setAttentionUid(3);
    a=attentionService.findFans(a);
    attentionService.deleteAttention(a);
  }
  
  @Test
  public void find() {
    List<Attention> aList = attentionService.findAttentionByUser(2);
    for(Attention a:aList) {
      System.out.println(a);
    }
  }
  
  @Test
  public void find2() {
    int a = attentionService.findAttentionCount(2);
    System.out.println(a);
  }
  
  @Test
  public void find3() {
    int a = attentionService.findFansCount(6);
    System.out.println(a);
  }

}
