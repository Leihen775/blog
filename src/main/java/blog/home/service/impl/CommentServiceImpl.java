package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.ArticleMapper;
import blog.home.dao.CommentMapper;
import blog.home.dao.UserInfoMapper;
import blog.home.model.Comment;
import blog.home.service.ICommentService;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {
  
  @Autowired
  CommentMapper commentMapper;
  @Autowired
  ArticleMapper articleMapper;
  @Autowired
  UserInfoMapper userInfoMapper;
  
  @Override
  public void addComment(Comment comment) {
    commentMapper.addComment(comment);
    articleMapper.addCommentCount(comment.getArticle_id());
    userInfoMapper.addCommentCount(comment.getUser_id());
  }

  @Override
  public void deleteComment(Comment comment) {
    commentMapper.deleteComment(comment.getId());
    articleMapper.minusCommentCount(comment.getArticle_id());
    userInfoMapper.minusCommentCount(comment.getUser_id());
  }

  @Override
  public List<Comment> findCommentByArticle(int aid) {
    return commentMapper.findCommentByArticle(aid);
  }

}
