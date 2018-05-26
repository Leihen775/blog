package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.home.dao.AnswerMapper;
import blog.home.dao.QuestionMapper;
import blog.home.model.Answer;
import blog.home.service.IAnswerService;

@Service
@Transactional
public class AnswerServiceImpl implements IAnswerService{
  
  @Autowired
  AnswerMapper answerMapper;
  @Autowired
  QuestionMapper questionMapper;
  @Override
  public void addAnswer(Answer answer) {
    answerMapper.addAnswer(answer);
    questionMapper.addAnswerCount(answer.getQuestionId());
  }
  
  @Override
  public void deleteAnswer(Answer answer) {
    answerMapper.deleteAnswer(answer.getId());
    questionMapper.minusAnswerCount(answer.getQuestionId());
  }
  
  @Override
  public PageInfo<Answer> findAnswerByQid(int qid) {
    PageHelper.startPage(1, 3);
    PageInfo<Answer> pageInfo = new PageInfo<Answer>(answerMapper.findAnswerByQid(qid),3);
//    List<Answer> answerList = answerMapper.findAnswerByQid(qid);
    List<Answer> replyList = answerMapper.findReplyAnswerByQid(qid);
    pageInfo.getList().addAll(replyList);
    return pageInfo;
  }
  
}
