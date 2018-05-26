package blog.home.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import blog.home.model.MessageUser;
import blog.home.model.UserInfo;
import blog.home.service.IMessageService;

@Controller
public class messageController {
  
  @Autowired
  IMessageService messageService;
  
  @RequestMapping(value= "/action/codeValidator",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String codeValidator(String code,HttpServletRequest request) throws IOException{
    String verCode = (String)request.getSession().getAttribute("verCode");
    Map<String,Boolean> map = new HashMap<String,Boolean>();
    if(!verCode.equals(code)) {
      map.put("valid",false);
    }else {
      map.put("valid",true);
    }
    request.getSession().removeAttribute("verCode");
    return JSON.toJSONString(map);
  }
  
  @RequestMapping(value="/findcount",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String findCount(HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    String count = null;
    try {
      int num = messageService.findCount(user.getId());
      count = JSON.toJSONString(num);
    } catch (Exception e) {
      //e.printStackTrace();
    }
    return count;
  }
  
  @RequestMapping(value="/findMessageList",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public PageInfo<MessageUser> findMessageList(int pageNum,HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    PageInfo<MessageUser> pageInfo = new PageInfo<MessageUser>();
    try {
      pageInfo = messageService.findSysMessage(user.getId(), pageNum);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pageInfo;
  }
  
  @RequestMapping(value="/deleteMessage",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String deleteMessage(int id){
    String msg = null;
    try {
      messageService.deleteRecipientMessage(id);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value="/deleteAllMessage",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String deleteAllMessage(HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    String msg = null;
    try {
      messageService.deleteAllMessage(user.getId());
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value="/updateMessageRead",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updateMessageRead(int id){
    String msg = null;
    try {
      messageService.MessageRead(id);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value="/updateAllMessageRead",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updateAllMessageRead(HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    String msg = null;
    try {
      messageService.AllMessageRead(user.getId());
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
}
