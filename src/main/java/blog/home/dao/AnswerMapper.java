package blog.home.dao;

import java.util.List;

import blog.home.model.Answer;

public interface AnswerMapper {
  
  /**  
   * @Title: addAnswer
   * @Description: 提交回答
   * @return void
   * @throws
   */
  public void addAnswer(Answer answer);
  
  /**  
   * @Title: deleteAnswer
   * @Description: 删除回答
   * @return void
   * @throws
   */
  public void deleteAnswer(int id);
  
  /**  
   * @Title: deleteByQuestion
   * @Description: 根据问题ID删除回答
   * @return void
   * @throws
   */
  public void deleteByQuestion(int qid);
  
  /**  
   * @Title: deleteByQuestionBatch
   * @Description: 根据问题ID批量删除回答
   * @return void
   * @throws
   */
  public void deleteByQuestionBatch(List<Integer> qidList);
  
  /**  
   * @Title: findAnswerByQid
   * @Description: 查询回答
   * @return List<Answer>
   * @throws
   */
  public List<Answer> findAnswerByQid(int qid);
  
  /**  
   * @Title: findReplyAnswerByQid
   * @Description: 查询回答的回复
   * @return List<Answer>
   * @throws
   */
  public List<Answer> findReplyAnswerByQid(int qid);

}
