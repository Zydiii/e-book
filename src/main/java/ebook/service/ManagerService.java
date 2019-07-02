package ebook.service;

import ebook.entity.Books;
import ebook.entity.SeeOrder;
import ebook.entity.SeeUser;
import ebook.entity.Userinfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public interface ManagerService {
    public List<SeeUser> seeUser(String date1, String date2) throws Exception;
    public List<SeeOrder> seeOrder(String date1, String date2) throws Exception;
    public List<Books> getBookAll();
    public String addBook(Map<String, String> formData);
    public String sendOrder(String order_id, int book_id);
    public String updateBook(Books row);
    public String updateCover(String cover1, String cover2);
    public String delBook(String id);
    public List<Userinfo> getUsers();
    public List<Userinfo> changeNUsers(Userinfo user);
    public List<Userinfo> changeYUsers(Userinfo user);
}
