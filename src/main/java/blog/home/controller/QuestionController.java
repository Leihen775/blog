package blog.home.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
  
  @RequestMapping(value= "/findQuestionList",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public PageInfo<Question> findQuestionlList(HttpServletRequest request, HttpServletResponse response) throws IOException{
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    PageInfo<Question> pageInfo =  questionService.findQuestionByUser(user.getId());
    return pageInfo;
  }

}
