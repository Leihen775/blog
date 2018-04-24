package blog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Collect;
import blog.home.service.ICollectService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class CollectTest {
  
  @Autowired
  ICollectService collectServiceImpl;
  
  @Test
  public void add() {
    Collect collect = new Collect();
    collect.setTitle("张晓菲收藏的第二条文章");
    collect.setUrl("http://www.");
    collect.setArticleId(18);
    collect.setUserId(3);
    collectServiceImpl.addCollect(collect);
  }
  
  @Test
  public void delete() {
    List<Collect> list = collectServiceImpl.findCollectByUser(3);
    List<Integer> idList = new ArrayList<Integer>();
    for(Collect c:list) {
      int id = c.getId();
      idList.add(id);
    }
    collectServiceImpl.deleteCollectBatch(idList);
  }
  
  @Test
  public void update() {
    List<Collect> list = collectServiceImpl.findCollectByUser(3);
    Collect collect = new Collect();
    collect.setId(list.get(0).getId());
    collect.setTitle("张晓菲收藏的第一条文章");
    collectServiceImpl.updateCollect(collect);
  }
  
  @Test
  public void find() {
    int count = collectServiceImpl.findCountByUser(3);
    System.out.println(count);
  }
  
  @Test
  public void find2() {
    Collect collect = collectServiceImpl.findCollectById(4);
    System.out.println(collect);
  }
  
}
