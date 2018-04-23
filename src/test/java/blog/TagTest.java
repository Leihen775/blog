package blog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Tag;
import blog.home.service.ITagService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TagTest {
  
  @Autowired
  ITagService tagService;

  @Test
  public void addTest() {
    Tag tag = new Tag();
    tag.setTag("spring");
    tag.setUser_id(1);
    tagService.addTag(tag);
  }
  
  @Test
  public void deleteTest() {
    tagService.deleteTag(5);
  }
  
  @Test
  public void deleteTest2() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(6);
    list.add(7);
    
    tagService.deleteTagBatch(list);;
  }
  
  @Test
  public void findTest1() {
    List<Tag> list=tagService.findTagByUser(3);
    for(Tag t:list) {
      System.out.println(t);
    }
  }
  
  @Test
  public void findTest2() {
    Tag t=tagService.findTagById(3);
    System.out.println(t);
  }
  
}
