package blog.home.dao;

import java.util.List;

import blog.home.model.Comment;

/**  
 * @ClassName: CommentMapper  
 * @Description: 操作数据库blog_comment博客评论表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface CommentMapper {
  
  /**  
   * @Title: addComment
   * @Description: 添加评论
   * @return void
   * @throws
   */
  public void addComment(Comment comment);
  
  /**  
   * @Title: deleteComment
   * @Description: 根据评论ID删除评论
   * @return void
   * @throws
   */
  public void deleteComment(int id);
  
  /**  
   * @Title: findCommentByArticle
   * @Description: 根据文章ID查询评论信息
   * @return List<Comment>
   * @throws
   */
  public List<Comment> findCommentByArticle(int aid);
  
}
