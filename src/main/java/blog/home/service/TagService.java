package blog.home.service;

import java.util.List;

import blog.home.model.Tag;

public interface TagService {
  
  /**  
   * @Title: addTag
   * @Description: 添加个人标签
   * @return void
   * @throws
   */
  public void addTag(Tag tag);
  
  /**  
   * @Title: deleteTag
   * @Description: 根据ID删除个人标签
   * @return void
   * @throws
   */
  public void deleteTag(int id);
  
  /**  
   * @Title: deleteTagBatch
   * @Description: 根据ID 批量删除个人标签
   * @return void
   * @throws
   */
  public void deleteTagBatch(List<Integer> idList);
  
  /**  
   * @Title: updateTag
   * @Description: 根据ID 修改个人标签
   * @return void
   * @throws
   */
  public void updateTag(Tag tag);
  
  /**  
   * @Title: findTagByUser
   * @Description: 根据用户ID 查询个人标签
   * @return List<Tag>
   * @throws
   */
  public List<Tag> findTagByUser(int uid);
  
  /**  
   * @Title: findTagById
   * @Description: 根据ID查询个人标签
   * @return Tag
   * @throws
   */
  public Tag findTagById(int id);
  
}
