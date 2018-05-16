package blog.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import blog.home.service.IArticleService;

@Controller
public class ArticleController {
  
  @Autowired
  IArticleService articleService;

}
