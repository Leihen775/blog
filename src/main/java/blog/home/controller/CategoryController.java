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

import blog.home.model.Category;
import blog.home.service.ICategoryService;

@Controller
public class CategoryController {
  
  @Autowired
  ICategoryService categoryService;
  
  @RequestMapping(value= "/findAllCategory",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public List<Category> findAllCategory(HttpServletRequest request, HttpServletResponse response){
    List<Category> list = new ArrayList<Category>();
    try {
      list = categoryService.findAllCategory();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
}
