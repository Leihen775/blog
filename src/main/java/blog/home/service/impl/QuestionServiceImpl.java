package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.AnswerMapper;
import blog.home.dao.QuestionMapper;
import blog.home.model.Question;
import blog.home.service.IQuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService{
  
  @Autowired
  QuestionMapper questionMapper;
  @Autowired
  AnswerMapper answerMapper;
  @Override
  public void addQuestion(Question question) {
    questionMapper.addQuestion(question);
  }
  
  @Override
  public void deleteQuestion(int id) {
    questionMapper.deleteQuestion(id);
    answerMapper.deleteByQuestion(id);
  }
  
  @Override
  public void deleteQuestionBatch(List<Integer> idList) {
    questionMapper.deleteQuestionBatch(idList);
    answerMapper.deleteByQuestionBatch(idList);
  }
  
  @Override
  public Question findQuestion(int id) {
    Question question = new Question();
    question=questionMapper.findQuestion(id);
    questionMapper.addClickCount(id);
    return question;
  }
  
  @Override
  public List<Question> findAllQuestion() {
    return questionMapper.findAllQuestion();
  }
  
  @Override
  public List<Question> findQuestionByTitle(String title) {
    return questionMapper.findQuestionByTitle(title);
  }
  
  @Override
  public List<Question> findQuestionByUser(int uid) {
    return questionMapper.findQuestionByUser(uid);
  }

}
