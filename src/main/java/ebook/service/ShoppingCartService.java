package ebook.service;

import ebook.entity.Cart;
import ebook.entity.CartInfo;
import ebook.entity.Carts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carts")
public interface ShoppingCartService {
    public Cart addShoppingCart(Carts cart);
    public List<CartInfo> getShoppingCart(String userID);
    public Cart doneSubmit(String address, String name, String phone, List<CartInfo> cart);
}
