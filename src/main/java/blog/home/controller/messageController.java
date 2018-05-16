package blog.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import blog.home.model.UserInfo;
import blog.home.service.IMessageService;

@Controller
public class messageController {
  
  @Autowired
  IMessageService messageService;
  
  @RequestMapping(value="/findCount",method= {RequestMethod.POST,RequestMethod.GET})
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
  
}
