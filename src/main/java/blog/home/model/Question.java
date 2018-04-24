package blog.home.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Question {
  private int id;
  private String title;
  private String content;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date publishTime;
  private int clickCount;
  private int answerCount;
  private int sameCount;
  private int state;
  private int userId;
  private UserInfo userInfo;
}
