package blog.shiro.factory;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import blog.home.model.Permission;
import blog.home.service.IPermissionService;



/** 
 * 自定义FilterChainDefinitionMap  
 * 
 */  
public class FilterChainDefinitionMapBuilder {
	
	@Autowired  
	private IPermissionService permissionService;	
	
	/** 
     * 由于在FilterChainDefinitionMap 中是需要顺序的，所以我们选择用LinkedHashMap 
     */  
	public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		//获取所有Resource  
        List<Permission> list = permissionService.findAllPermission();
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接  
        for (Iterator<Permission> it = list.iterator(); it.hasNext();) {  
          Permission resource = it.next();  
          //如果不为空值添加到section中  
          if(!StringUtils.isEmpty(resource.getUrl()) && !StringUtils.isEmpty(resource.getPermission())) {  
              map.put(resource.getUrl(),resource.getPermission());  
          }
        }
        //默认所有url以  /admin/开始的都要进行拦截
		map.put("/**", "authc");
	
		return map;
	}
	
}
