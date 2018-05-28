package blog.home.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import blog.home.model.Tag;
import blog.home.model.UserInfo;
import blog.home.service.ITagService;

@Controller
public class TagController {
  
  @Autowired
  ITagService tagService;
  
  @RequestMapping(value= "/addTag",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String addTag(Tag tag,HttpServletRequest req){
    UserInfo user = (UserInfo)req.getSession().getAttribute("user");
    tag.setUserId(user.getId());
    String msg = null;
    try {
      tagService.addTag(tag);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/deleteTag",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String deleteTag(int id){
    String msg = null;
    try {
      tagService.deleteTag(id);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/deleteTagBatch",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String deleteTagBatch(String[] idList,HttpServletRequest request, HttpServletResponse response){
    return null;
  }
  
  @RequestMapping(value= "/updateTag",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updateTag(Tag tag,HttpServletRequest req){
    String msg = null;
    try {
      tagService.updateTag(tag);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/findAllTagByUser",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public List<Tag> findAllTagByUser(HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    List<Tag> list = new ArrayList<Tag>();
    try {
      list = tagService.findAllTagByUser(user.getId());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  @RequestMapping(value= "/findTagByUser",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public PageInfo<Tag> findTagByUser(int pageNum,HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    PageInfo<Tag> pageInfo = new PageInfo<Tag>();
    try {
      pageInfo = tagService.findTagByUser(user.getId(),pageNum);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pageInfo;
  }
  
  @RequestMapping(value= "/findTag",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public Tag findTag(HttpServletRequest request){
    return null;
  }
  
  
}
