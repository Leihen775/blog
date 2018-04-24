package blog.home.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Answer {
  private int id;
  private String content;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publishTime;
  private int questionId;
  private int questionerUid;
  private int responderId;
  private int pid;
  private UserInfo userInfo; //回答人信息
}
