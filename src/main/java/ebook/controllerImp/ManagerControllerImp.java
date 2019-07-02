package ebook.controllerImp;

import ebook.controller.ManagerController;
import ebook.dao.BooksMapper;
import ebook.dao.ItemsMapper;
import ebook.dao.OrdersMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.*;
import ebook.service.ManagerService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/manager")
public class ManagerControllerImp implements ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping(path = "/SeeUser", method = RequestMethod.GET)
    @ResponseBody
    public List<SeeUser> seeUser(@RequestParam String date1, @RequestParam String date2) throws Exception{
        return managerService.seeUser(date1, date2);
    }

    @RequestMapping(path = "/SeeOrder", method = RequestMethod.GET)
    @ResponseBody
    public List<SeeOrder> seeOrder(@RequestParam String date1, @RequestParam String date2) throws Exception{
        return managerService.seeOrder(date1, date2);
    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getBookAll(){
        return managerService.getBookAll();
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestBody Map<String, String> formData){
        return managerService.addBook(formData);
    }

    @RequestMapping(path="/sendOrder", method = RequestMethod.GET)
    @ResponseBody
    public String sendOrder(@RequestParam String order_id, @RequestParam int book_id){
       return managerService.sendOrder(order_id, book_id);
    }

    @RequestMapping(path = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public String updateBook(@RequestBody Books row){
        return managerService.updateBook(row);
    }

    @RequestMapping(path = "/updateCover", method = RequestMethod.GET)
    public String updateCover(@RequestParam String cover1, @RequestParam String cover2){ return managerService.updateCover(cover1, cover2); }

    @RequestMapping(path = "/deleteBook", method = RequestMethod.GET)
    @ResponseBody
    public String delBook(@RequestParam String id){
        return managerService.delBook(id);
    }

    @RequestMapping( path="/users", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUsers(){
        return managerService.getUsers();
    }

    @RequestMapping(path = "/changeN", method = RequestMethod.POST)
    @ResponseBody
    public List<Userinfo> changeNUsers(@RequestBody Userinfo user){
       return managerService.changeNUsers(user);
    }

    @RequestMapping(path = "/changeY", method = RequestMethod.POST)
    @ResponseBody
    public List<Userinfo> changeYUsers(@RequestBody Userinfo user){
        return managerService.changeYUsers(user);
    }


}
