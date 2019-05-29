package ebook.service;

import ebook.entity.Cart;
import ebook.entity.Find;
import ebook.entity.OrderBook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public interface HomeService {
    public List<OrderBook> getTime(Find time) throws Exception;
    public String recOrder(String order_id, int book_id);
    public List<OrderBook> getOrderAll();
    public List<OrderBook> getOrder(int ID);
    public Cart deleteOrder(String order_id, String book_id);
}
