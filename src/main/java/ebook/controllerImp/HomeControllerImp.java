package ebook.controllerImp;

import ebook.controller.HomeController;
import ebook.entity.*;
import ebook.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeControllerImp implements HomeController {
    @Autowired
    HomeService homeService;

    @RequestMapping(path = "/gettime", method = RequestMethod.POST)
    @ResponseBody
    public List<OrderBook> getTime(@RequestBody Find time) throws Exception{
        return homeService.getTime(time);
    }

    @RequestMapping(path = "/commentBook", method = RequestMethod.POST)
    @ResponseBody
    public String commentBook(@RequestBody Comment comment){
        return homeService.commentBook(comment);
    }

    @RequestMapping(path="/recOrder", method = RequestMethod.GET)
    @ResponseBody
    public String recOrder(@RequestParam String order_id, @RequestParam int book_id){
        return homeService.recOrder(order_id, book_id);
    }

    @RequestMapping(path = "/orderAll", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderBook> getOrderAll(){
        return homeService.getOrderAll();
    }

    @RequestMapping(path = "/order", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderBook> getOrder(@RequestParam int ID){
        return homeService.getOrder(ID);
    }

    @RequestMapping(path = "/orderEval", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderBook> getOrderEval(@RequestParam int ID){
        return homeService.getOrderEval(ID);
    }

    @RequestMapping(path = "/deleteOrder", method = RequestMethod.GET)
    @ResponseBody
    public Cart deleteOrder(@RequestParam String order_id, @RequestParam String book_id){
        return homeService.deleteOrder(order_id, book_id);
    }
}
