package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.PermissionMapper;
import blog.home.model.Permission;
import blog.home.service.IPermissionService;

@Transactional
@Service
public class PermissionServiceImpl implements IPermissionService {
  
  @Autowired
  PermissionMapper permissionMapper;

  @Override
  public void addPermission(Permission permission) {
    permissionMapper.addPermission(permission);
  }

  @Override
  public void deletePermission(int id) {
    permissionMapper.deletePermission(id);
  }

  @Override
  public void updatePermission(Permission permission) {
    permissionMapper.updatePermission(permission);
  }

  @Override
  public Permission findPermission(int id) {
    return permissionMapper.findPermission(id);
  }

  @Override
  public List<Permission> findAllPermission() {
    return permissionMapper.findAllPermission();
  }

}
