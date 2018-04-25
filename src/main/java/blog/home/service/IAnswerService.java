package blog.home.service;

import java.util.List;

import blog.home.model.Answer;

public interface IAnswerService {
  
  /**  
   * @Title: addAnswer
   * @Description: 添加回答
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
  public void deleteAnswer(Answer answer);
  
  /**  
   * @Title: findAnswerByQid
   * @Description: 查询回答
   * @return List<Answer>
   * @throws
   */
  public List<Answer> findAnswerByQid(int qid);

}
