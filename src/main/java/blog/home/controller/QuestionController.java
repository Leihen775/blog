package blog.home.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import blog.home.model.Question;
import blog.home.model.UserInfo;
import blog.home.service.IQuestionService;

@Controller
public class QuestionController {
  
  @Autowired
  IQuestionService questionService;
  
  @RequestMapping(value= "/addQuestion",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String addQuestion(Question question,HttpServletRequest req) {
    String msg=null;
    UserInfo user = (UserInfo)req.getSession().getAttribute("user");
    question.setUserId(user.getId());
    question.setPublishTime(new Date());
    try {
      questionService.addQuestion(question);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/deleteQuestion",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String deleteQuestion(int id) {
    String msg=null;
    try {
      questionService.deleteQuestion(id);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/trashQuestion",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String trashQuestion(int id) {
    String msg=null;
    Question question = new Question();
    question.setId(id);
    question.setState(2);
    try {
      questionService.trashQuestion(question);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/findQuestionList",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public PageInfo<Question> findQuestionlList(int pageNum,int state,HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    PageInfo<Question> pageInfo = new PageInfo<Question>();
    try {
      pageInfo = questionService.findQuestionByUser(user.getId(), pageNum, state);
    } catch (Exception e) {
//      e.printStackTrace();
    }
    return pageInfo;
  }

}
