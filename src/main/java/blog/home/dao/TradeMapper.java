package blog.home.dao;

import java.util.List;

import blog.home.model.Trade;

/**  
 * @ClassName: TradeMapper  
 * @Description: 操作数据库user_trade用户行业表dao
 * @author Leihen  
 * @date 2018年4月20日      
 */  
public interface TradeMapper {

  /**  
   * @Title: addTrade
   * @Description: 添加行业信息
   * @return void
   * @throws
   */
  public void addTrade(Trade trade);
  
  /**  
   * @Title: deleteTrade
   * @Description: 根据ID删除行业信息
   * @return void
   * @throws
   */
  public void deleteTrade(int id);
  
  /**  
   * @Title: deleteTradeBatch
   * @Description: 批量删除行业信息
   * @return void
   * @throws
   */
  public void deleteTradeBatch(List<Integer> idList);
  
  /**  
   * @Title: updateTrade
   * @Description: 根据ID修改行业信息
   * @return void
   * @throws
   */
  public void updateTrade(Trade trade);
  
  /**  
   * @Title: findAllTrade
   * @Description: 查找所有行业信息
   * @return List<Trade>
   * @throws
   */
  public List<Trade> findAllTrade();
  
  /**  
   * @Title: findTradeById
   * @Description: 根据ID查找行业信息
   * @return Trade
   * @throws
   */
  public Trade findTradeById(int id);
  
  
}
