package ebook.serviceImp;

import ebook.controller.ShoppingCartController;
import ebook.dao.BooksMapper;
import ebook.dao.CartsMapper;
import ebook.dao.ItemsMapper;
import ebook.dao.OrdersMapper;
import ebook.entity.*;
import ebook.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService {

    @Autowired
    CartsMapper cartsMapper;

    @Autowired
    BooksMapper booksMapper;

    @Autowired
    ItemsMapper itemsMapper;

    @Autowired
    OrdersMapper ordersMapper;

    public Cart addShoppingCart(@RequestBody Carts cart) {
        CartsExample cartsExample = new CartsExample();
        CartsExample.Criteria criteria = cartsExample.createCriteria();
        int bookid = cart.getBookId();
        int userid = cart.getUserId();
        criteria.andUserIdEqualTo(userid).andBookIdEqualTo(bookid).andStateEqualTo(1);
        List<Carts> getList = cartsMapper.selectByExample(cartsExample);
        Cart c = new Cart();
        if (getList.size() == 0) {
            cartsMapper.insert(cart);
            c.setStatus(1);
            c.setMessage("Add New");
        } else {
            int num = cart.getNum() + getList.get(0).getNum();
            if (num > cart.getRemain()) {
                c.setStatus(0);
                c.setMessage("Too Much");
            } else {
                cart.setNum(num);
                //cartsMapper.deleteByPrimaryKey(getList.get(0).getId());
                //cartsMapper.insert(cart);
                cartsMapper.updateByExampleSelective(cart, cartsExample);
                c.setStatus(1);
                c.setMessage("Ok");
            }
        }
        return c;
    }

    public List<CartInfo> getShoppingCart(@RequestParam String userID) {
        CartsExample cartsExample = new CartsExample();
        CartsExample.Criteria criteria = cartsExample.createCriteria();
        int id = Integer.parseInt(userID);
        criteria.andUserIdEqualTo(id).andStateEqualTo(1);
        List<Carts> getList = cartsMapper.selectByExample(cartsExample);
        List<CartInfo> l = new ArrayList<CartInfo>();
        for (int i = 0; i < getList.size(); i++) {
            CartInfo cartinfo = new CartInfo();
            BooksExample booksExample = new BooksExample();
            BooksExample.Criteria criteria1 = booksExample.createCriteria();
            id = getList.get(i).getBookId();
            criteria1.andIdEqualTo(id);
            List<Books> b = booksMapper.selectByExample(booksExample);
            cartinfo.setCover(b.get(0).getCover());
            cartinfo.setNum(getList.get(i).getNum());
            cartinfo.setPrice(b.get(0).getPrice());
            cartinfo.setTitle(b.get(0).getTitle());
            cartinfo.setISBN(b.get(0).getIsbn());
            cartinfo.setCart_id(getList.get(i).getId());
            cartinfo.setBook_id(getList.get(i).getBookId());
            cartinfo.setUser_id(getList.get(i).getUserId());
            cartinfo.setWriter(getList.get(i).getWriter());
            l.add(cartinfo);
        }
        return l;
    }

    public Cart doneSubmit(@RequestParam String address, @RequestParam String name, @RequestParam String phone, @RequestBody List<CartInfo> cart) {
        float sum = 0;
        int user_id = cart.get(0).getUser_id();
        for (int i = 0; i < cart.size(); i++) {
            CartInfo c = new CartInfo();
            c = cart.get(i);
            int book_id = c.getBook_id();
            int cart_id = c.getCart_id();
            int sale = c.getNum();
            //变更cart状态
            CartsExample cartsExample = new CartsExample();
            CartsExample.Criteria criteria = cartsExample.createCriteria();
            criteria.andIdEqualTo(cart_id);
            List<Carts> getList = cartsMapper.selectByExample(cartsExample);
            Carts ca = new Carts();
            ca = getList.get(0);
            ca.setState(0);
            cartsMapper.updateByExampleSelective(ca, cartsExample);
            //变更books库存和销量
            BooksExample booksExample = new BooksExample();
            BooksExample.Criteria criteria1 = booksExample.createCriteria();
            criteria1.andIdEqualTo(book_id);
            List<Books> b = booksMapper.selectByExample(booksExample);
            Books bs = new Books();
            bs = b.get(0);
            int r = bs.getRemains();
            int s = bs.getSalenum();
            bs.setRemains(r - sale);
            bs.setSalenum(s + sale);
            booksMapper.updateByExampleSelective(bs, booksExample);
            float p = sale * c.getPrice();
            sum += p;
        }
        //添加orders
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria2 = ordersExample.createCriteria();
        Orders orders = new Orders();
        orders.setUserId(user_id);
        Date d = new Date();
        orders.setOdertime(d);
        orders.setMoney(sum);
        orders.setReceiveraddress(address);
        orders.setReceivername(name);
        orders.setReceiverphone(phone);
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        orders.setId(str);
        ordersMapper.insert(orders);

        //添加orderitem
        for (int i=0; i < cart.size(); i++){
            CartInfo c = new CartInfo();
            c = cart.get(i);
            int book_id = c.getBook_id();
            int sale = c.getNum();
            ItemsExample itemsExample = new ItemsExample();
            ItemsExample.Criteria criteria3 = itemsExample.createCriteria();
            Items items = new Items();
            items.setOrderId(str);
            items.setNum(sale);
            items.setBookId(book_id);
            items.setSee(1);
            items.setState(0);
            itemsMapper.insert(items);
        }
        Cart c = new Cart();
        c.setMessage("OK");
        c.setStatus(1);
        return c;
    }
}
