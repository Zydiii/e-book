package ebook.controller;

import ebook.entity.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public interface ManagerController {
    @RequestMapping(path = "/SeeUser", method = RequestMethod.GET)
    @ResponseBody
    public List<SeeUser> seeUser(String date1, String date2) throws Exception;
    @RequestMapping(path = "/SeeOrder", method = RequestMethod.GET)
    @ResponseBody
    public List<SeeOrder> seeOrder(String date1, String date2) throws Exception;
    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getBookAll();
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(Map<String, String> formData);
    @RequestMapping(path="/sendOrder", method = RequestMethod.GET)
    @ResponseBody
    public String sendOrder(String order_id, int book_id);
    @RequestMapping(path = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public String updateBook(Books row);
    @RequestMapping(path = "/updateCover", method = RequestMethod.GET)
    @ResponseBody
    public String updateCover(String cover1, String cover2);
    @RequestMapping(path = "/deleteBook", method = RequestMethod.GET)
    @ResponseBody
    public String delBook(String id);
    @RequestMapping( path="/users", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUsers();
    @RequestMapping(path = "/changeN", method = RequestMethod.POST)
    @ResponseBody
    public List<Userinfo> changeNUsers(Userinfo user);
    @RequestMapping(path = "/changeY", method = RequestMethod.POST)
    @ResponseBody
    public List<Userinfo> changeYUsers(Userinfo user);

}
