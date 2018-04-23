package blog.home.service;

import java.util.List;

import blog.home.model.Trade;

public interface TradeService {
  
  /**  
   * @Title: addTrade
   * @Description: 添加行业信息
   * @return void
   * @throws
   */
  public void addTrade(Trade trade);
  
  /**  
   * @Title: deleteTrade
   * @Description: 单个删除行业信息
   * @return void
   * @throws
   */
  public void deleteTrade(int tid);
  
  /**  
   * @Title: deleteTrade
   * @Description: 批量删除行业信息
   * @return void
   * @throws
   */
  public void deleteTradeBatch(List<Integer> tidList);
  
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
