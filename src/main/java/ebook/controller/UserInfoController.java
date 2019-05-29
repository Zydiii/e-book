package ebook.controller;

import ebook.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public interface UserInfoController {
    @RequestMapping(path = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public String addAddress(Address newAddress);
    @RequestMapping(path = "/changeAddress", method = RequestMethod.POST)
    @ResponseBody
    public String changeAddress(Address change);
    @RequestMapping(path = "/delAddress", method = RequestMethod.POST)
    @ResponseBody
    public String delAddress(Address del);
    @RequestMapping(path = "/getAddress", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAddress(String ID);
    @RequestMapping(path = "/checkPhone", method = RequestMethod.GET)
    @ResponseBody
    public Cart checkPhone(String phone);
    @RequestMapping(path = "/check", method = RequestMethod.GET)
    @ResponseBody
    public Cart check(String logid, String email);
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(Userinfo user);
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUserAll();
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Userinfo getUserById(String id);
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Login getLogin(Userinfo useri);
}
