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
   * @Title: deleteCommentByArticle
   * @Description: 根据文章ID删除评论信息
   * @return void
   * @throws
   */
  public void deleteCommentByArticle(int aid);
  
  /**  
   * @Title: deleteCommentByAidBatch
   * @Description: 根据多个文章ID删除评论信息
   * @return void
   * @throws
   */
  public void deleteCommentByAidBatch(List<Integer> aidList);
  
  /**  
   * @Title: findCommentByAid
   * @Description: 根据文章ID查询一级评论信息
   * @return List<Comment>
   * @throws
   */
  public List<Comment> findCommentByAid(int aid);
  
  /**  
   * @Title: findReplyCommentByAid
   * @Description: 根据文章ID查询次级评论信息
   * @return List<Comment>
   * @throws
   */
  public List<Comment> findReplyCommentByAid(int aid);
  
}
