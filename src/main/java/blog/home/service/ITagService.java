package blog.home.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.home.model.Tag;

public interface ITagService {
  
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
   * @Description: 根据用户ID 分页查询个人标签
   * @return List<Tag>
   * @throws
   */
  public PageInfo<Tag> findTagByUser(int uid,int pageNum);
  
  /**  
   * @Title: findAllTagByUser
   * @Description: 根据用户ID 查询所有个人标签
   * @return List<Tag>
   * @throws
   */
  public List<Tag> findAllTagByUser(int uid);
  
  /**  
   * @Title: findTagById
   * @Description: 根据ID查询个人标签
   * @return Tag
   * @throws
   */
  public Tag findTagById(int id);
  
}
