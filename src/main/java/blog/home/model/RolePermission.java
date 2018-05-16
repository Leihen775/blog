package blog.home.model;

import lombok.Data;

@Data
public class RolePermission {
  private int roleId;
  private int permissionId;
  private Permission permission;
}
