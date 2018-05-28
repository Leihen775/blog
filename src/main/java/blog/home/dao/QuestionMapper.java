package blog.home.dao;

import java.util.List;

import blog.home.model.Question;

/**  
 * @ClassName: QuestionMapper  
 * @Description: 操作数据库sys_question问提表dao  
 * @author Leihen  
 * @date 2018年4月24日      
 */  
public interface QuestionMapper {
  
  /**  
   * @Title: addQuestion
   * @Description: 提出问题
   * @return void
   * @throws
   */
  public void addQuestion(Question question);
  
  /**  
   * @Title: addClickCount
   * @Description: 浏览一次问题
   * @return void
   * @throws
   */
  public void addClickCount(int id);
  
  /**  
   * @Title: addAnswerCount
   * @Description: 回答一次问题
   * @return void
   * @throws
   */
  public void addAnswerCount(int id);
  
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
  public void deleteQuestionBatch(List<Integer> qidList);
  
  /**  
   * @Title: minusAnswerCount
   * @Description: 回答数-1
   * @return void
   * @throws
   */
  public void minusAnswerCount(int id);
  
  /**  
   * @Title: updateQuestion
   * @Description: 修改问题
   * @return void
   * @throws
   */
  public void updateQuestion(Question question);
  
  /**  
   * @Title: findQuestion
   * @Description: 查询问题详细信息
   * @return Question
   * @throws
   */
  public Question findQuestion(int id);
  
  /**  
   * @Title: findAllQuestion
   * @Description: 查询问题简略信息
   * @return List<Question>
   * @throws
   */
  public List<Question> findAllQuestion();
  
  /**  
   * @Title: findQuestionByTitle
   * @Description: 根据 问题标题 模糊查询问题简略信息
   * @return List<Question>
   * @throws
   */
  public List<Question> findQuestionByTitle(String title);
  
  /**  
   * @Title: findQuestionByUser
   * @Description: 根据用户Id查询问题
   * @return List<Question>
   * @throws
   */
  public List<Question> findQuestionByUser(int uid);
  
  /**  
   * @Title: findArticleSolve
   * @Description: 查找已解决问题
   * @return List<Question>
   * @throws
   */
  public List<Question> findArticleSolve(int uid);
  
  /**  
   * @Title: findArticleUnsolved
   * @Description: 查找未解决问题
   * @return List<Question>
   * @throws
   */
  public List<Question> findArticleUnsolved(int uid);
  
  /**  
   * @Title: findQuestionGarbage
   * @Description: 查找进入回收站问题
   * @return List<Question>
   * @throws
   */
  public List<Question> findQuestionGarbage(int uid);
  
  
  /**  
   * @Title: findClickCount
   * @Description: 查询浏览数
   * @return int
   * @throws
   */
  public int findClickCount(int id);
  
  /**  
   * @Title: findAnswerCount
   * @Description: 查询回答数
   * @return int
   * @throws
   */
  public int findAnswerCount(int id);

}
