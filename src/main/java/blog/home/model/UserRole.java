package blog.home.model;

import lombok.Data;

@Data
public class UserRole {
  private int userId;
  private int roleId;
  private Role role;
}
