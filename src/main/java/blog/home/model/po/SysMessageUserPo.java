package blog.home.model.po;


import java.util.List;

import lombok.Data;

@Data
public class SysMessageUserPo {
  private UserPo user;
  private List<SysMessagePo> sysMessageList;
}
