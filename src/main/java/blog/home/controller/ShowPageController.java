package blog.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowPageController {
  @RequestMapping(value="/loginpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String loginpage() {
    return "login";
  }
  @RequestMapping(value="/registpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String registpage() {
    return "home/regist";
  }
  @RequestMapping(value="/person/personinfopage",method= {RequestMethod.POST,RequestMethod.GET})
  public String showInfo() {
    return "home/personInfo";
  }
  @RequestMapping(value="/header",method= {RequestMethod.POST,RequestMethod.GET})
  public String header() {
    return "home/header";
  }
  @RequestMapping(value="/footer",method= {RequestMethod.POST,RequestMethod.GET})
  public String footer() {
    return "home/footer";
  }
  @RequestMapping(value="/person/personalpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String personalpage() {
    return "home/person/personal";
  }
  @RequestMapping(value="/person/sysmessagepage",method= {RequestMethod.POST,RequestMethod.GET})
  public String sysmessagepage() {
    return "home/person/sysmessage";
  }
  @RequestMapping(value="/person/addarticlepage",method= {RequestMethod.POST,RequestMethod.GET})
  public String addarticlepage() {
    return "home/person/addarticle";
  }
  @RequestMapping(value="/person/managearticlepage",method= {RequestMethod.POST,RequestMethod.GET})
  public String managearticlepage() {
    return "home/person/managearticle";
  }
  @RequestMapping(value="/person/managetagpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String managetagpage() {
    return "home/person/managetag";
  }
  @RequestMapping(value="/person/addquestionpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String addquestionpage() {
    return "home/person/addquestion";
  }
  @RequestMapping(value="/person/managequestionpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String managequestionpage() {
    return "home/person/managequestion";
  }
  @RequestMapping(value="/person/setaccountpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String setaccountpage() {
    return "home/person/setaccount";
  }
  @RequestMapping(value="/home/homepage",method= {RequestMethod.POST,RequestMethod.GET})
  public String homepage() {
    return "home/home";
  }
  @RequestMapping(value="/home/questionlistpage",method= {RequestMethod.POST,RequestMethod.GET})
  public String questionlistpage() {
    return "home/questionlist";
  }
  
}
