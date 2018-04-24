package blog.home.service;

import java.util.List;

import blog.home.model.Comment;

public interface ICommentService {
  
  /**  
   * @Title: addComment
   * @Description: 添加评论
   * @return void
   * @throws
   */
  public void addComment(Comment comment);
  
  /**  
   * @Title: deleteComment
   * @Description: 删除评论
   * @return void
   * @throws
   */
  public void deleteComment(Comment Comment);
  
  /**  
   * @Title: findCommentByArticle
   * @Description: 根据文章ID 查询评论
   * @return List<Comment>
   * @throws
   */
  public List<Comment> findCommentByArticle(int aid);

}
