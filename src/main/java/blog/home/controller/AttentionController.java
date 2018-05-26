package blog.home.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.home.model.UserInfo;
import blog.home.service.IAttentionService;

@Controller
public class AttentionController {
  
  @Autowired
  IAttentionService attentionService;
  
  @RequestMapping(value= "/findFocusAndFans",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public List<Integer> findFocusAndFans(HttpServletRequest request){
    UserInfo user =(UserInfo)request.getSession().getAttribute("user");
    List<Integer> result = new ArrayList<Integer>();
    try {
      int focus = attentionService.findAttentionCount(user.getId());
      int fans = attentionService.findFansCount(user.getId());
      result.add(focus);
      result.add(fans);
    }catch(Exception e) {
    }
    return result;
  }

}
