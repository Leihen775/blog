package blog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.home.model.Trade;
import blog.home.service.ITradeService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TradeTest {
  
  @Autowired
  ITradeService tradeService;
  
  @Test
  public void addTrade() {
    Trade trade = new Trade();
    trade.setName("其他");
    tradeService.addTrade(trade);
  }
  
  @Test
  public void deleteTrade() {
    tradeService.deleteTrade(44);
  }
  
  @Test
  public void deleteTrade2() {
    List<Integer> idList = new ArrayList<Integer>();
    idList.add(45);
    idList.add(46);
    tradeService.deleteTradeBatch(idList);
  }
  
  @Test
  public void findTrade() {
    List<Trade> tradeList = tradeService.findAllTrade();
    for(Trade trade:tradeList) {
      System.out.println(trade);
    }
  }
  
  @Test
  public void findTrade2() {
    Trade trade = tradeService.findTradeById(34);
    System.out.println(trade);
  }

}
