package ebook.controllerImp;

import ebook.controller.ShoppingCartController;
import ebook.entity.*;
import ebook.dao.BooksMapper;
import ebook.dao.CartsMapper;
import ebook.dao.ItemsMapper;
import ebook.dao.OrdersMapper;
import ebook.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carts")
public class ShoppingCartControllerImp implements ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(path = "/addCart", method = RequestMethod.POST)
    @ResponseBody
    public Cart addShoppingCart(@RequestBody Carts cart) {
        return shoppingCartService.addShoppingCart(cart);
    }

    @RequestMapping(path = "/getCart", method = RequestMethod.GET)
    @ResponseBody
    public List<CartInfo> getShoppingCart(@RequestParam String userID) {
        return shoppingCartService.getShoppingCart(userID);
    }

    @RequestMapping(path = "/doneSubmit", method = RequestMethod.POST)
    @ResponseBody
    public Cart doneSubmit(@RequestParam String address, @RequestParam String name, @RequestParam String phone, @RequestBody List<CartInfo> cart) {
        return shoppingCartService.doneSubmit(address, name, phone, cart);
    }
}
