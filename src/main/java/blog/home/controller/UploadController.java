package blog.home.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/uploads")
public class UploadController {
  
  @RequestMapping(value= "/uploaduserpic",method= RequestMethod.POST)
  @ResponseBody
  public String uploadUserPic(MultipartFile avatar,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String fi = avatar.getOriginalFilename();
    // 提取文件拓展名
    String fileNameExtension = fi.substring(fi.lastIndexOf("."), fi.length());
    // 生成实际存储的真实文件名
    String realName = UUID.randomUUID().toString() + fileNameExtension;
    // 图片存放的真实路径
    String path = "D:\\Tomcat8.5\\uploads\\userimg";
    String realPath =  path+"\\"+realName;
    File filePath = new File(path);
    //判断路径是否存在，如果不存在就创建一个
    if (!filePath.exists()) { 
      filePath.mkdirs();
    }
    // 将文件写入指定路径下
    avatar.transferTo(new File(realPath));
    // 返回图片的URL地址
    String url = "http://localhost:8080/img/userimg/"+realName;
    
    return JSON.toJSONString(url);
  }
  
  @RequestMapping(value= "/uploadarticlepic",method= RequestMethod.POST)
  @ResponseBody
  public String uploadArticlePic(MultipartFile img,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String fi = img.getOriginalFilename();
    String fileNameExtension = fi.substring(fi.lastIndexOf("."), fi.length());
    String realName = UUID.randomUUID().toString() + fileNameExtension;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
    String date = df.format(new Date());
    
    String path = "D:\\Tomcat8.5\\uploads\\articleimg\\"+date;
    String realPath =  path+"\\"+realName;
    File filePath = new File(path);
    if (!filePath.exists()) { 
      filePath.mkdirs();
    }
    img.transferTo(new File(realPath));
    String url = "Http://localhost:8080/img/articleimg/"+date+"/"+realName;
    return JSON.toJSONString(url);
  }
  
  
  
}
