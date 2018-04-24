package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Message;
import blog.home.model.MessageUser;
import blog.home.service.IMessageService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class MessageTest {
  
  @Autowired
  IMessageService messageService;
  
  @Test
  public void send1() {
    Message message = new Message();
    message.setContent("吴刚发给张晓菲的一条私信");
    message.setPublishTime(new Date());
    message.setSenderId(10);
    messageService.sendSecretMessage(message, 3);
  }
  
  @Test 
  public void send2() {
    Message message = new Message();
    message.setContent("系统发给赵飞燕的一条私信");
    message.setPublishTime(new Date());
    messageService.sendSysMessage(message, 5);
  }
  
  @Test
  public void send3() {
    Message message = new Message();
    message.setContent("系统发给所有人的一条私信");
    message.setPublishTime(new Date());
    List<Integer> idList = new ArrayList<Integer>();
    for(int i=1;i<=12;i++) {
      idList.add(i);
    }
    messageService.sendSysMessageBatch(message, idList);
  }
  
  @Test
  public void keep() {
    Message message = new Message();
    message.setContent("系统发给赵飞燕的一条私信");
    message.setPublishTime(new Date());
    messageService.keepMessage(message);
  }
  
  @Test
  public void delete() {
    List<MessageUser> list = messageService.findSecretMessageRead(5);
    int mid = list.get(0).getMessage().getId();
    messageService.deleteSenderMessage(mid);
  }
  
  @Test
  public void find() {
    List<MessageUser> list = messageService.findSecretMessage(5);
    for(MessageUser mu:list) {
      System.out.println(mu);
    }
  }
  
  @Test
  public void find2() {
    List<MessageUser> list = messageService.findSysMessage(5);
    for(MessageUser mu:list) {
      System.out.println(mu);
    }
  }
  
  @Test
  public void find3() {
    List<MessageUser> list = messageService.findSecretMessage(5);
    int id =list.get(0).getId();
    MessageUser messageUser = messageService.findMessage(id);
    System.out.println(messageUser);
  }
  
  @Test
  public void find4() {
    List<MessageUser> list = messageService.findSecretMessageRead(5);
    int id =list.get(0).getId();
    MessageUser messageUser = messageService.findMessage(id);
    System.out.println(messageUser);
  }
  
  @Test
  public void find5() {
    int count = messageService.findCount(5);
    System.out.println(count);
  }
  
  @Test
  public void find6() {
    int count = messageService.findSecretCount(5);
    System.out.println(count);
  }
  
  @Test
  public void find7() {
    int count = messageService.findSysCount(5);
    System.out.println(count);
  }

}
