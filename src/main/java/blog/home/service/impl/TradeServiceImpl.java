package blog.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.TradeMapper;
import blog.home.dao.UserInfoMapper;
import blog.home.model.Trade;
import blog.home.service.ITradeService;

@Service
@Transactional
public class TradeServiceImpl implements ITradeService {
  
  @Autowired
  TradeMapper tradeMapper;
  @Autowired
  UserInfoMapper userInfoMapper;

  @Override
  public void addTrade(Trade trade) {
    tradeMapper.addTrade(trade);
  }
  
  @Override
  public void deleteTrade(int tid) {
    tradeMapper.deleteTrade(tid);
    userInfoMapper.updateUserTrade(tid);
  }

  @Override
  public void deleteTradeBatch(List<Integer> tidList) {
    tradeMapper.deleteTradeBatch(tidList);
    userInfoMapper.updateUserTradeBatch(tidList);
  }

  @Override
  public void updateTrade(Trade trade) {
    tradeMapper.updateTrade(trade);
  }

  @Override
  public List<Trade> findAllTrade() {
    return tradeMapper.findAllTrade();
  }

  @Override
  public Trade findTradeById(int id) {
    return tradeMapper.findTradeById(id);
  }

}
