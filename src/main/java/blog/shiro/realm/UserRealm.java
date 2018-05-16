package blog.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import blog.home.model.UserInfo;
import blog.home.service.IUserInfoService;

public class UserRealm extends AuthorizingRealm  {

    @Autowired
    IUserInfoService userInfoService;    
    String password;

    /**
     * 为登录成功的用户授予角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
      String userName=(String) principals.getPrimaryPrincipal();
      SimpleAuthorizationInfo  authorizationInfo=new SimpleAuthorizationInfo();
      authorizationInfo.setRoles(userInfoService.findRoles(userName));
      authorizationInfo.setStringPermissions(userInfoService.findPermissions(userName));
      return authorizationInfo;
    }

    
    /**
     * 验证当前的用户
     */
    @SuppressWarnings("unused")
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
      String userName=(String) token.getPrincipal();
      //realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
      String realmName = getName();
      UserInfo user=new UserInfo();
      
      user= userInfoService.findUserByInputInfo(userName);
      System.out.println(user.getUsername()+"----"+user.getPassword());
      if(user!=null){
        
        //加点盐
        ByteSource credentialsSalt=ByteSource.Util.bytes("3309");
        
        AuthenticationInfo authInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),credentialsSalt,realmName );
        return authInfo;
      }else{
        return null;  
      }
    }
}