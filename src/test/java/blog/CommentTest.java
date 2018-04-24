package blog;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Comment;
import blog.home.service.ICommentService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class CommentTest {
  
  @Autowired
  ICommentService commentService;
  
  @Test
  public void add() {
    Comment comment = new Comment();
    comment.setArticleId(17);
    comment.setContent("回复马斐");
    comment.setPublishTime(new Date());
    comment.setRecipientUid(6);
    comment.setUserId(7);
    comment.setPid(2);
    commentService.addComment(comment);
  }
  
  @Test
  public void find() {
    List<Comment> list=commentService.findCommentByArticle(17);
    for(Comment c:list) {
      if(c.getPid()==0) {
        System.out.println(c);
        for(Comment c2:list) {
          if(c2.getPid()==c.getId()) {
            System.out.println(c2);
          }
        }
      }
    }
  }

}
