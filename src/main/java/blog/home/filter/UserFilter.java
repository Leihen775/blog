package blog.home.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.home.model.UserInfo;



public class UserFilter implements Filter {
  
  public void destroy() {
    // TODO Auto-generated method stub
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    /**
     * 判断session中是否有用户的信息
     */
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse res = (HttpServletResponse)response;
    UserInfo user = (UserInfo)req.getSession().getAttribute("user");
    if(user!=null) {
      chain.doFilter(request, response);
    }else {
      redirect(req, res);
    }
  }
  
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }
  
  /**
   * 重定向登录页
   * @param request
   * @param response
   * @throws IOException
   */
  public void redirect(HttpServletRequest request,HttpServletResponse response) throws IOException{
      PrintWriter out = response.getWriter();  
      out.println("<html>");      
      out.println("<script>");      
      out.println("window.location.href ='" +request.getContextPath()+ "/loginpage'");      
      out.println("</script>");      
      out.println("</html>"); 
  }

}
