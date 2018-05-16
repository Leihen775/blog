package blog.home.model;

import java.util.List;

import lombok.Data;

@Data
public class Role {
  private int id;
  private String role; //角色标识 程序中判断使用,如"admin"
  private String description; //角色描述,UI界面显示使用
  private List<RolePermission> rolePermissionList;
}
