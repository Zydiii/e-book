package ebook.controller;

import ebook.dao.BooksMapper;
import ebook.dao.ItemsMapper;
import ebook.dao.OrdersMapper;
import ebook.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    ItemsMapper itemsMapper;

    @Autowired
    BooksMapper booksMapper;

    @RequestMapping(path = "/gettime", method = RequestMethod.POST)
    @ResponseBody
    public List<OrderBook> getTime(@RequestBody Find time) throws Exception{
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(time.getTime1());
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(time.getTime2());
        criteria.andUserIdEqualTo(time.getId()).andOdertimeBetween(date1, date2);
        List<Orders> g = ordersMapper.selectByExample(ordersExample);
        List<OrderBook> my = new ArrayList<OrderBook>();

        for(int i=0; i<g.size(); i++){
            String id = g.get(i).getId();
            ItemsExample itemsExample = new ItemsExample();
            ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
            criteria1.andOrderIdEqualTo(id).andSeeEqualTo(1);
            List<Items> o = itemsMapper.selectByExample(itemsExample);
            for(int j=0; j < o.size(); j++){
                OrderBook orderBook = new OrderBook();
                orderBook.setNum(o.get(j).getNum());
                orderBook.setOrder_id(o.get(j).getOrderId());
                orderBook.setOrder_time(g.get(i).getOdertime());
                BooksExample booksExample = new BooksExample();
                BooksExample.Criteria criteria2 = booksExample.createCriteria();
                criteria2.andIdEqualTo(o.get(j).getBookId());
                List<Books> ook = booksMapper.selectByExample(booksExample);
                float price = ook.get(0).getPrice();
                orderBook.setPrice(price * o.get(j).getNum());
                orderBook.setTitle(ook.get(0).getTitle());
                orderBook.setBook_id(ook.get(0).getId());
                orderBook.setReceiverAddress(g.get(i).getReceiveraddress());
                orderBook.setReceiverName(g.get(i).getReceivername());
                orderBook.setReceiverPhone(g.get(i).getReceiverphone());
                orderBook.setCover(ook.get(0).getCover());
                orderBook.setISBN(ook.get(0).getIsbn());
                orderBook.setWriter(ook.get(0).getWriter());

                my.add(orderBook);
            }
        }
        return my;
    }

    @RequestMapping(path="/recOrder", method = RequestMethod.GET)
    @ResponseBody
    public String recOrder(@RequestParam String order_id, @RequestParam int book_id){
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andBookIdEqualTo(book_id).andOrderIdEqualTo(order_id);
        List<Items> o = itemsMapper.selectByExample(itemsExample);
        o.get(0).setState(2);
        itemsMapper.updateByExampleSelective(o.get(0), itemsExample);
        return  "1";
    }

    @RequestMapping(path = "/orderAll", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderBook> getOrderAll(){
        OrdersExample ordersExample = new OrdersExample();
        List<Orders> g = ordersMapper.selectByExample(ordersExample);
        List<OrderBook> my = new ArrayList<OrderBook>();

        for(int i=0; i<g.size(); i++){
            String id = g.get(i).getId();
            ItemsExample itemsExample = new ItemsExample();
            ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
            criteria1.andOrderIdEqualTo(id);
            List<Items> o = itemsMapper.selectByExample(itemsExample);
            for(int j=0; j < o.size(); j++){
                OrderBook orderBook = new OrderBook();
                orderBook.setNum(o.get(j).getNum());
                orderBook.setOrder_id(o.get(j).getOrderId());
                orderBook.setOrder_time(g.get(i).getOdertime());
                BooksExample booksExample = new BooksExample();
                BooksExample.Criteria criteria2 = booksExample.createCriteria();
                criteria2.andIdEqualTo(o.get(j).getBookId());
                List<Books> ook = booksMapper.selectByExample(booksExample);
                float price = ook.get(0).getPrice();
                orderBook.setPrice(price * o.get(j).getNum());
                orderBook.setTitle(ook.get(0).getTitle());
                orderBook.setBook_id(ook.get(0).getId());
                orderBook.setReceiverAddress(g.get(i).getReceiveraddress());
                orderBook.setReceiverName(g.get(i).getReceivername());
                orderBook.setReceiverPhone(g.get(i).getReceiverphone());
                orderBook.setCover(ook.get(0).getCover());
                orderBook.setISBN(ook.get(0).getIsbn());
                orderBook.setWriter(ook.get(0).getWriter());
                orderBook.setState(o.get(j).getState());
                my.add(orderBook);
            }
        }
        return my;
    }


    @RequestMapping(path = "/order", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderBook> getOrder(@RequestParam int ID){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andUserIdEqualTo(ID);
        List<Orders> g = ordersMapper.selectByExample(ordersExample);
        List<OrderBook> my = new ArrayList<OrderBook>();

        for(int i=0; i<g.size(); i++){
            String id = g.get(i).getId();
            ItemsExample itemsExample = new ItemsExample();
            ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
            criteria1.andOrderIdEqualTo(id).andSeeEqualTo(1);
            List<Items> o = itemsMapper.selectByExample(itemsExample);
            for(int j=0; j < o.size(); j++){
                OrderBook orderBook = new OrderBook();
                orderBook.setNum(o.get(j).getNum());
                orderBook.setOrder_id(o.get(j).getOrderId());
                orderBook.setOrder_time(g.get(i).getOdertime());
                BooksExample booksExample = new BooksExample();
                BooksExample.Criteria criteria2 = booksExample.createCriteria();
                criteria2.andIdEqualTo(o.get(j).getBookId());
                List<Books> ook = booksMapper.selectByExample(booksExample);
                float price = ook.get(0).getPrice();
                orderBook.setPrice(price * o.get(j).getNum());
                orderBook.setTitle(ook.get(0).getTitle());
                orderBook.setBook_id(ook.get(0).getId());
                orderBook.setReceiverAddress(g.get(i).getReceiveraddress());
                orderBook.setReceiverName(g.get(i).getReceivername());
                orderBook.setReceiverPhone(g.get(i).getReceiverphone());
                orderBook.setCover(ook.get(0).getCover());
                orderBook.setISBN(ook.get(0).getIsbn());
                orderBook.setWriter(ook.get(0).getWriter());
                orderBook.setState(o.get(j).getState());
                my.add(orderBook);
            }
        }
        return my;
    }



    @RequestMapping(path = "/deleteOrder", method = RequestMethod.GET)
    @ResponseBody
    public Cart deleteOrder(@RequestParam String order_id, @RequestParam String book_id){
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
        int id = Integer.parseInt(book_id);
        criteria1.andOrderIdEqualTo(order_id).andBookIdEqualTo(id);
        List<Items> o = itemsMapper.selectByExample(itemsExample);
        Items i = new Items();
        i = o.get(0);
        i.setSee(0);
        itemsMapper.updateByExampleSelective(i, itemsExample);
        Cart t = new Cart();
        t.setStatus(1);
        t.setMessage("OK");
        return t;
    }

//    @RequestMapping(path = "/getTime", method = RequestMethod.GET)
//    @ResponseBody
//    public List<> getTime(@RequestParam String time1, @RequestParam String time2){
//
//
//
//    }
}
