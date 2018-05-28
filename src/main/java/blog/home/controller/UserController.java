package blog.home.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import blog.home.model.UserInfo;
import blog.home.service.IUserInfoService;
import blog.home.util.VerifyCodeUtils;

@Controller
public class UserController {
  
  @Autowired
  IUserInfoService userService;
  
  @RequestMapping(value= "/authImage",method= {RequestMethod.POST,RequestMethod.GET})
  public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException{
    response.setHeader("Pragma", "No-cache"); 
    response.setHeader("Cache-Control", "no-cache"); 
    response.setDateHeader("Expires", 0); 
    response.setContentType("image/jpeg"); 
    //生成随机字串 
    String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
    //存入会话session 
    HttpSession session = request.getSession(true); 
    //删除以前的
    session.removeAttribute("verCode");
    session.setAttribute("verCode", verifyCode.toLowerCase());
    //生成图片 
    int w = 100, h = 30; 
    VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
  }

  @RequestMapping(value= "/login",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String login(UserInfo user,String code,Boolean isRemember,
      HttpServletRequest request){
    /*Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
    String code1 = (String)request.getSession().getAttribute("verCode");
    try {
      if(!code1.equalsIgnoreCase(code)) {
        //DOTO
      }else {
      //执行认证操作.
        if(isRemember) {
          token.setRememberMe(true);
        }else {
          token.setRememberMe(false);
        }
        subject.login(token);
      }
    }catch (AuthenticationException ae) {
      System.out.println("登陆失败: " + ae.getMessage());
    }*/
    String hashAlgorithmName = "MD5";
    ByteSource salt=ByteSource.Util.bytes("3309");
    int hashIterations = 1024; 
    String vercode = (String)request.getSession().getAttribute("verCode");
    String msg = null;
    try {
      if(!vercode.equals(code)) {
        msg = "CODEERROR";
      }else {
        UserInfo userInfo = userService.findUserByInputInfo(user.getUsername());
        String result = (new SimpleHash(hashAlgorithmName, user.getPassword(), salt, hashIterations)).toString();
        if(!result.equals(userInfo.getPassword())) {
          msg = "ERROR";
        }else {
          request.getSession().setAttribute("user", userInfo);
          request.getSession().removeAttribute("verCode");
          msg = "SUCCESS";
        }
      }
    }catch(Exception e) {
      e.printStackTrace();
      msg = "ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/action/logout",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String logout(HttpServletRequest request){
    HttpSession session = request.getSession(true);
    session.removeAttribute("user");
    String msg = "SUCCESS";
    return msg;
  }
  
  @RequestMapping(value= "/action/isExist",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String isExist(String inputinfo){
    Map<String,Boolean> map = new HashMap<String,Boolean>();
    Boolean msg ;
    try {
      UserInfo userInfo = userService.findUserByInputInfo(inputinfo);
      if(!userInfo.equals(null)) {
        msg = false;
      }else {
        msg = true;
      }
    }catch(Exception e) {
      msg = true;
    }
    map.put("valid", msg);
    return JSON.toJSONString(map);
  }
  
  @RequestMapping(value= "/action/regist",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String regist(UserInfo user,String code,HttpServletRequest request){
    String hashAlgorithmName = "MD5";
    ByteSource salt=ByteSource.Util.bytes("3309");
    int hashIterations = 1024; 
    String msg = null;
    try {
      Object result = new SimpleHash(hashAlgorithmName, user.getPassword(), salt, hashIterations);
      user.setPassword(result.toString());
      user.setImagePath("../static/image/头像.png");
      userService.addUserInfo(user);
      msg = "SUCCESS";
    }catch(Exception e) {
      msg = "ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/findUserInfo",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public UserInfo findUserInfo(HttpServletRequest request){
    UserInfo user =(UserInfo)request.getSession().getAttribute("user");
    UserInfo userinfo = new UserInfo();
    try {
      userinfo = userService.findUser(user.getId());
    }catch(Exception e) {
    }
    return userinfo;
  }
  
  @RequestMapping(value= "/updateUserInfo",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updateUserInfo(UserInfo user,HttpServletRequest req){
    UserInfo userinfo = (UserInfo)req.getSession().getAttribute("user");
    String msg = null;
    try {
      System.out.println(user);
      /*int[] str = {1,2};
      System.out.println(str[2]);*/
      user.setId(userinfo.getId());
      userService.updateUserInfo(user);
      msg="SUCCESS";
    }catch(Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/action/updateUserImg",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updateUserImg(UserInfo user,HttpServletRequest request) {
    UserInfo _user =(UserInfo)request.getSession().getAttribute("user");
    user.setId(_user.getId());
    String msg = null;
    try {
      userService.updateUserInfo(user);
      msg="SUCCESS";
    }catch(Exception e) {
      msg="ERROR";
      e.printStackTrace();
    }
    return msg;
  }
  
  @RequestMapping(value= "/action/updatePassword",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updatePassword(String password,String oldpassword,HttpServletRequest req) {
    String msg=null;
    String hashAlgorithmName = "MD5";
    ByteSource salt=ByteSource.Util.bytes("3309");
    int hashIterations = 1024;
    UserInfo user = (UserInfo)req.getSession().getAttribute("user");
    String result = (new SimpleHash(hashAlgorithmName,oldpassword, salt, hashIterations)).toString();
    try {
      if(!result.equals(user.getPassword())) {
        msg = "PERROR";
      }else {
        Object newpassword =new SimpleHash(hashAlgorithmName,password, salt, hashIterations);
        user.setPassword(newpassword.toString());
        userService.updateUserInfo(user);
        req.getSession().removeAttribute("user");
        req.getSession().setAttribute("user", user);
        msg="SUCCESS";
      }
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  @RequestMapping(value= "/action/updateEmail",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public String updateEmail(String password,String email,HttpServletRequest req) {
    String msg=null;
    String hashAlgorithmName = "MD5";
    ByteSource salt=ByteSource.Util.bytes("3309");
    int hashIterations = 1024; 
    UserInfo user = (UserInfo)req.getSession().getAttribute("user");
    String result = (new SimpleHash(hashAlgorithmName, password, salt, hashIterations)).toString();
    try {
      if(!result.equals(user.getPassword())) {
        msg = "PERROR";
      }else {
        user.setAccountNum(email);
        user.setEmail(email);
        userService.updateUserInfo(user);
        req.getSession().removeAttribute("user");
        req.getSession().setAttribute("user", user);
        msg="SUCCESS";
      }
    } catch (Exception e) {
      e.printStackTrace();
      msg="ERROR";
    }
    return msg;
  }
  
  
}
