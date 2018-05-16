package blog.home.service;

import java.util.List;

import blog.home.model.Permission;

public interface IPermissionService {
  
  public void addPermission(Permission permission);
  
  public void deletePermission(int id);
  
  public void updatePermission(Permission permission);
  
  public Permission findPermission(int id);
  
  public List<Permission> findAllPermission();

}
