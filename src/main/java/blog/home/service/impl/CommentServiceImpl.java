package blog.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.CommentMapper;
import blog.home.service.ICommentService;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {
  
  @Autowired
  CommentMapper commentMapper;

}
