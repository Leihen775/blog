package blog.home.model;

import lombok.Data;

@Data
public class Permission {
  private int id;
  private String permission; //权限标识 程序中判断使用,如"user:create"
  private String url;
}
