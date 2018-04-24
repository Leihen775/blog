package blog;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.UserInfo;
import blog.home.service.IUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserTest {
  
  @Autowired
  IUserInfoService userInfoService;
  
  @Test
  public void addUser() {
    UserInfo userInfo = new UserInfo();
    userInfo.setAccountNum("541413212");
    userInfo.setUsername("晓君");
    userInfo.setPassword("12");
    userInfo.setSex(1);
    userInfo.setTrade_id(9);
    userInfoService.addUserInfo(userInfo);
  }
  
  @Test
  public void update() {
    UserInfo userInfo = new UserInfo();
    userInfo.setId(11);
    userInfo.setRealname("郑娇");
    userInfo.setJob("学生");
    userInfo.setTrade_id(5);
    userInfo.setAddress("郑州");
    userInfo.setBirth(new Date());
    userInfo.setEmail("541413211@qq.com");
    
    userInfoService.updateUserInfo(userInfo);
  }
  
  @Test
  public void find() {
    UserInfo userInfo = userInfoService.findUser(11);
    System.out.println(userInfo);
  }
  
  @Test
  public void find2() {
    UserInfo userInfo = userInfoService.findUserByInputInfo("541413203");
    System.out.println(userInfo);
  }

}
