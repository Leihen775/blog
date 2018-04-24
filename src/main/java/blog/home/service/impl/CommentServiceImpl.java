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
    articleMapper.addCommentCount(comment.getArticleId());
    userInfoMapper.addCommentCount(comment.getUserId());
  }

  @Override
  public void deleteComment(Comment comment) {
    commentMapper.deleteComment(comment.getId());
    articleMapper.minusCommentCount(comment.getArticleId());
    userInfoMapper.minusCommentCount(comment.getUserId());
  }

  @Override
  public List<Comment> findCommentByArticle(int aid) {
    List<Comment> list=commentMapper.findCommentByAid(aid);
    List<Comment> replyList=commentMapper.findReplyCommentByAid(aid);
    list.addAll(replyList);
    return list;
  }

}
