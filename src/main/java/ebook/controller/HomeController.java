package ebook.controller;

import ebook.entity.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public interface HomeController {
    @RequestMapping(path = "/commentBook", method = RequestMethod.POST)
    @ResponseBody
    String commentBook(Comment comment);
    @RequestMapping(path = "/gettime", method = RequestMethod.POST)
    @ResponseBody
    List<OrderBook> getTime(Find time) throws Exception;
    @RequestMapping(path="/recOrder", method = RequestMethod.GET)
    @ResponseBody
    String recOrder(String order_id, int book_id);
    @RequestMapping(path = "/orderAll", method = RequestMethod.GET)
    @ResponseBody
    List<OrderBook> getOrderAll();
    @RequestMapping(path = "/order", method = RequestMethod.GET)
    @ResponseBody
    List<OrderBook> getOrder(int ID);
    @RequestMapping(path = "/orderEval", method = RequestMethod.GET)
    @ResponseBody
    List<OrderBook> getOrderEval(int ID);
    @RequestMapping(path = "/deleteOrder", method = RequestMethod.GET)
    @ResponseBody
    Cart deleteOrder(String order_id, String book_id);

}
