package blog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Category;
import blog.home.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})     
public class CategoryTest{
  
  @Autowired
  private CategoryService categoryService;
  
  @Test
  public void addTest() {
    Category category = new Category();
    category.setId(6);
    category.setName("游戏开发");
    category.setCode("1216");
    categoryService.addCategory(category);
  }
  
  @Test
  public void deleteTest() {
    int id=4;
    categoryService.deleteCategory(id);
  }
  
  @Test
  public void deleteBatchTest() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(6);
    list.add(7);
    System.out.println("111");
    categoryService.deleteCategoryBatch(list);
  }
  
  @Test
  public void updateTest() {
    Category category = new Category();
    category.setId(10);
    category.setName("物联网");
    categoryService.updateCategory(category);
  }
  
  @Test
  public void findTest1() {
    List<Category> list = new ArrayList<Category>();
    list = categoryService.findAllCategory("2");
    for(Category c:list) {
      System.out.println(c);
    }
  }
  
  @Test
  public void findTest2() {
    Category category = categoryService.findCategoryById(2);
    System.out.println(category);
  }
  
  @Test
  public void findTest3() {
    List<Category> list = categoryService.findCategoryByName("发");
    for(Category c:list) {
      System.out.println(c);
    }
  }

}
