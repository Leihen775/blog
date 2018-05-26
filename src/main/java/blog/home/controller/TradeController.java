package blog.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.home.model.Trade;
import blog.home.service.ITradeService;

@Controller
public class TradeController {
  
  @Autowired
  ITradeService tradeService;
  
  @RequestMapping(value= "/findTrade",method= {RequestMethod.POST,RequestMethod.GET})
  @ResponseBody
  public List<Trade> findTrade(HttpServletRequest request, HttpServletResponse response)
      throws IOException{
    List<Trade> list = tradeService.findAllTrade();
    return list;
  }

}
