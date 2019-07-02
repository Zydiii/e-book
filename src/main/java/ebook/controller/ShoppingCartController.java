package ebook.controller;

import ebook.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public interface ShoppingCartController {
    @RequestMapping(path = "/addCart", method = RequestMethod.POST)
    @ResponseBody
    public Cart addShoppingCart(Carts cart);
    @RequestMapping(path = "/getCart", method = RequestMethod.GET)
    @ResponseBody
    public List<CartInfo> getShoppingCart(String userID);
    @RequestMapping(path = "/doneSubmit", method = RequestMethod.POST)
    @ResponseBody
    public Cart doneSubmit(String address, String name, String phone, List<CartInfo> cart);
}
