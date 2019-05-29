package ebook.serviceImp;

import ebook.controller.ManagerController;
import ebook.dao.BooksMapper;
import ebook.dao.ItemsMapper;
import ebook.dao.OrdersMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.*;
import ebook.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImp implements ManagerService {
    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    BooksMapper booksMapper;

    @Autowired
    ItemsMapper itemsMapper;

    @Autowired
    OrdersMapper ordersMapper;

    public List<SeeUser> seeUser(@RequestParam String date1, @RequestParam String date2) throws Exception{
        UserinfoExample userinfoExample = new UserinfoExample();
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        List<SeeUser> seeUsers = new ArrayList<SeeUser>();
        Date date11 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        Date date22 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        for(int ii = 0; ii < users.size(); ii++) {
            OrdersExample ordersExample = new OrdersExample();
            OrdersExample.Criteria criteria = ordersExample.createCriteria();
            criteria.andUserIdEqualTo(users.get(ii).getId()).andOdertimeBetween(date11, date22);
            List<Orders> o = ordersMapper.selectByExample(ordersExample);
            float pays = 0;
            int nums = 0;
            for (int jj = 0; jj < o.size(); jj++) {
                pays += o.get(jj).getMoney();
                ItemsExample itemsExample = new ItemsExample();
                ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
                criteria1.andOrderIdEqualTo(o.get(jj).getId());
                List<Items> o1 = itemsMapper.selectByExample(itemsExample);
                for (int kk = 0; kk < o1.size(); kk++) {
                    nums += o1.get(kk).getNum();
                }
            }
            SeeUser s = new SeeUser();
            s.setLogid(users.get(ii).getLogid());
            s.setNums(nums);
            s.setPays(pays);
            seeUsers.add(s);
        }
        return seeUsers;
    }

    public List<SeeOrder> seeOrder(@RequestParam String date1, @RequestParam String date2) throws Exception{
        Date date11 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        Date date22 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);

        List<SeeOrder> orders = new ArrayList<SeeOrder>();
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andValidEqualTo(1);
        List<Books> o = booksMapper.selectByExample(booksExample);
        for(int i = 0; i < o.size(); i++){
            ItemsExample itemsExample = new ItemsExample();
            ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
            criteria1.andBookIdEqualTo(o.get(i).getId());
            List<Items> o1 = itemsMapper.selectByExample(itemsExample);
            int num = 0;
            for(int j = 0; j < o1.size(); j++){
                OrdersExample ordersExample = new OrdersExample();
                OrdersExample.Criteria criteria2 = ordersExample.createCriteria();
                criteria2.andIdEqualTo(o1.get(j).getOrderId()).andOdertimeBetween(date11, date22);
                List<Orders> o2 = ordersMapper.selectByExample(ordersExample);
                for(int k = 0; k < o2.size(); k++){
                    ItemsExample itemsExample1 = new ItemsExample();
                    ItemsExample.Criteria criteria3 = itemsExample1.createCriteria();
                    criteria3.andBookIdEqualTo(o.get(i).getId()).andOrderIdEqualTo(o2.get(k).getId());
                    List<Items> o3 = itemsMapper.selectByExample(itemsExample1);
                    for(int kk = 0; kk < o3.size(); kk++){
                        num += o3.get(kk).getNum();
                    }
                }
            }
            SeeOrder seeOrder = new SeeOrder();
            seeOrder.setSales(num);
            seeOrder.setCover(o.get(i).getCover());
            seeOrder.setWriter(o.get(i).getWriter());
            seeOrder.setIsbn(o.get(i).getIsbn());
            seeOrder.setShopname(o.get(i).getShopname());
            seeOrder.setTitle(o.get(i).getTitle());
            seeOrder.setPrice(o.get(i).getPrice());
            seeOrder.setRemarknum(o.get(i).getRemarknum());

            orders.add(seeOrder);
        }
        return orders;
    }

    public List<Books> getBookAll(){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andValidEqualTo(1);
        return booksMapper.selectByExample(booksExample);
    }

    public String addBook(@RequestBody Map<String, String> formData){
        Books newBook = new Books();
        newBook.setCover(formData.get("cover"));
        newBook.setPrice(Float.parseFloat(formData.get("price")));
        newBook.setTitle(formData.get("title"));
        newBook.setShopname(formData.get("shopName"));
        newBook.setWriter(formData.get("writer"));
        newBook.setRemains(Integer.parseInt(formData.get("remains")));
        newBook.setIsbn(formData.get("ISBN"));
        newBook.setIntro(formData.get("intro"));
        newBook.setValid(1);
        newBook.setColor(0);
        newBook.setRemarknum(0);
        newBook.setSalenum(0);
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        newBook.setTime(date);
        booksMapper.insert(newBook);
        return "OK";
    }

    public String sendOrder(@RequestParam String order_id, @RequestParam int book_id){
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andBookIdEqualTo(book_id).andOrderIdEqualTo(order_id);
        List<Items> o = itemsMapper.selectByExample(itemsExample);
        o.get(0).setState(1);
        itemsMapper.updateByExampleSelective(o.get(0), itemsExample);
        return  "1";
    }

    public String updateBook(@RequestBody Books row){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIdEqualTo(row.getId());
        List<Books> o = booksMapper.selectByExample(booksExample);
        booksMapper.updateByExampleSelective(row, booksExample);
        return "OK";
    }

    public String delBook(@RequestParam String id){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        int Id = Integer.parseInt(id);
        criteria.andIdEqualTo(Id);
        List<Books> o = booksMapper.selectByExample(booksExample);
        Books i = new Books();
        i = o.get(0);
        i.setValid(0);
        booksMapper.updateByExampleSelective(i, booksExample);
        return "OK";
    }

    public List<Userinfo> getUsers(){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        return users;
    }

    public List<Userinfo> changeNUsers(@RequestBody Userinfo user){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        //int Id = Integer.parseInt()
        criteria.andIdEqualTo(user.getId());
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        users.get(0).setValid(0);
        userinfoMapper.updateByExampleSelective(users.get(0), userinfoExample);
        return getUsers();
    }

    public List<Userinfo> changeYUsers(@RequestBody Userinfo user){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andIdEqualTo(user.getId());
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        users.get(0).setValid(1);
        userinfoMapper.updateByExampleSelective(users.get(0), userinfoExample);
        return getUsers();
    }
}
