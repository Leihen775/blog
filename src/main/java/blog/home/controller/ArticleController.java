package blog.home.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import blog.home.model.Article;
import blog.home.model.UserInfo;
import blog.home.service.IArticleService;

@Controller
public class ArticleController {
  
  @Autowired
  IArticleService articleService;
  
  @RequestMapping(value= "/addArticle",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String addArticle(Article article,String[] tag,HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    article.setUserId(user.getId());
    List<Integer> tagList = new ArrayList<Integer>();
    for(int i=0;i<tag.length;i++) {
      tagList.add(Integer.valueOf(tag[i]));
    }
    Date datetime = new Date();
    article.setPublishTime(datetime);
    String msg = null;
    try {
      int[] str = {1,2};
      System.out.println(str[2]);
      articleService.addArticle(article, tagList);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/deleteArticle",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String deleteArticle(int id){
    String msg = null;
    try {
      /*int[] str = {1,2};
      System.out.println(str[2]);*/
      articleService.deleteArticle(id);
      msg="SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/findArticleList",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public PageInfo<Article> findArticleList(int state,int pageNum,HttpServletRequest request){
    UserInfo user = (UserInfo)request.getSession().getAttribute("user");
    PageInfo<Article> pageInfo = new PageInfo<Article>();
    try {
      pageInfo = articleService.findArticleByUser(user.getId(),pageNum,state);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pageInfo;
  }
  
}
