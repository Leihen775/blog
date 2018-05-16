package blog.home.dao;

import java.util.List;

import blog.home.model.Role;
import blog.home.model.RolePermission;

public interface RoleMapper {
  
  public void addRole(Role role);
  
  public void addRolePermission(RolePermission rolePermission);
  
  public void deleteRole(int id);
  
  public void deleteRolePermission(int rpid);
  
  public void updateRole(Role role);
  
  public void updateRolePermission(RolePermission rolePermission);
  
  public Role findRole(int id);
  
  public List<Role> findAllRole();
  
}
