package blog.home.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.home.model.Question;

public interface IQuestionService {
  
  /**  
   * @Title: addQuestion
   * @Description: 添加问题
   * @return void
   * @throws
   */
  public void addQuestion(Question question);
  
  /**  
   * @Title: deleteQuestion
   * @Description: 删除问题
   * @return void
   * @throws
   */
  public void deleteQuestion(int id);
  
  /**  
   * @Title: deleteQuestionBatch
   * @Description: 批量删除问题
   * @return void
   * @throws
   */
  public void deleteQuestionBatch(List<Integer> idList);
  
  /**  
   * @Title: findQuestion
   * @Description: 查询问题详细信息
   * @return Question
   * @throws
   */
  public Question findQuestion(int id);
  
  /**  
   * @Title: findAllQuestion
   * @Description: 查询所有问题
   * @return List<Question>
   * @throws
   */
  public PageInfo<Question> findAllQuestion();
  
  /**  
   * @Title: findQuestionByTitle
   * @Description: 模糊查询问题
   * @return List<Question>
   * @throws
   */
  public PageInfo<Question> findQuestionByTitle(String title);
  
  /**  
   * @Title: findQuestionByUser
   * @Description: 根据用户ID查询问题
   * @return List<Question>
   * @throws
   */
  public PageInfo<Question> findQuestionByUser(int uid);

}
