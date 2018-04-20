package blog.home.dao;

import java.util.List;

import blog.home.po.Tag;

/**  
 * @ClassName: TagMapper  
 * @Description: 操作数据库blog_tag个人标签表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface TagMapper {
  
  /**  
   * @Title: addTag
   * @Description: 添加个人标签
   * @return void
   * @throws
   */
  public void addTag(Tag tag);
  
  /**  
   * @Title: deleteTag
   * @Description: 删除个人标签
   * @return void
   * @throws
   */
  public void deleteTag(int id);
  
  /**  
   * @Title: deleteTagBatch
   * @Description: 根据ID批量删除个人标签
   * @return void
   * @throws
   */
  public void deleteTagBatch(List<Integer> idList);
  
  /**  
   * @Title: updateTag
   * @Description: 修改个人标签
   * @return void
   * @throws
   */
  public void updateTag(Tag tag);
  
  /**  
   * @Title: findAllTag
   * @Description: 根据用户ID查找所有个人标签
   * @return List<Tag>
   * @throws
   */
  public List<Tag> findAllTag(String user_id);
  
  /**  
   * @Title: findTagByid
   * @Description: 根据ID查找个人标签
   * @return List<Tag>
   * @throws
   */
  public List<Tag> findTagById(List<Integer> idList);
}
