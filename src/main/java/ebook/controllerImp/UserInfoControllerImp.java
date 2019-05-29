package ebook.controllerImp;

import ebook.controller.UserInfoController;
import ebook.dao.AddressMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.*;
import ebook.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoControllerImp implements UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(path = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public String addAddress(@RequestBody Address newAddress){
        return userInfoService.addAddress(newAddress);
    }

    @RequestMapping(path = "/changeAddress", method = RequestMethod.POST)
    @ResponseBody
    public String changeAddress(@RequestBody Address change){
       return userInfoService.changeAddress(change);
    }

    @RequestMapping(path = "/delAddress", method = RequestMethod.POST)
    @ResponseBody
    public String delAddress(@RequestBody Address del){
        return userInfoService.delAddress(del);
    }

    @RequestMapping(path = "/getAddress", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAddress(@RequestParam String ID){
       return userInfoService.getAddress(ID);
    }

    @RequestMapping(path = "/checkPhone", method = RequestMethod.GET)
    @ResponseBody
    public Cart checkPhone(@RequestParam String phone){
        return userInfoService.checkPhone(phone);
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    @ResponseBody
    public Cart check(@RequestParam String logid, @RequestParam String email){
        return userInfoService.check(logid, email);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody Userinfo user){
        return userInfoService.addUser(user);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUserAll(){
        return userInfoService.getUserAll();
    }

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Userinfo getUserById(@RequestParam String id){
        return userInfoService.getUserById(id);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Login getLogin(@RequestBody Userinfo useri){
       return userInfoService.getLogin(useri);
    }
}
