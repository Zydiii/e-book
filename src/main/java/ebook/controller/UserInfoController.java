package ebook.controller;

import ebook.dao.AddressMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    AddressMapper addressMapper;

    @RequestMapping(path = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public String addAddress(@RequestBody Address newAddress){
        AddressExample addressExample = new AddressExample();
//        AddressExample.Criteria criteria = addressExample.createCriteria();
        newAddress.setValid(1);
        addressMapper.insert(newAddress);
        return "Add OK";
    }

    @RequestMapping(path = "/changeAddress", method = RequestMethod.POST)
    @ResponseBody
    public String changeAddress(@RequestBody Address change){
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andIdEqualTo(change.getId());
        addressMapper.updateByExampleSelective(change, addressExample);
        return "Change OK";
    }

    @RequestMapping(path = "/delAddress", method = RequestMethod.POST)
    @ResponseBody
    public String delAddress(@RequestBody Address del){
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andIdEqualTo(del.getId());
        del.setValid(0);
        addressMapper.updateByExampleSelective(del, addressExample);
        return "Del OK";
    }

    @RequestMapping(path = "/getAddress", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> addAddress(@RequestParam String ID){
        int id = Integer.parseInt(ID);
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(id).andValidEqualTo(1);
        return addressMapper.selectByExample(addressExample);
    }

    @RequestMapping(path = "/checkPhone", method = RequestMethod.GET)
    @ResponseBody
    public Cart check(@RequestParam String phone){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Userinfo> a = userinfoMapper.selectByExample(userinfoExample);
        Cart c = new Cart();
        if(a.size() > 0){
            c.setStatus(0);
            return c;
        }
        else{
            c.setStatus(1);
            return c;
        }
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    @ResponseBody
    public Cart check(@RequestParam String logid, @RequestParam String email){
        UserinfoExample userinfoExample1 = new UserinfoExample();
        UserinfoExample.Criteria criteria1 = userinfoExample1.createCriteria();
        criteria1.andLogidEqualTo(logid);
        List<Userinfo> a1 = userinfoMapper.selectByExample(userinfoExample1);
        Cart c = new Cart();
        if(a1.size() > 0){
            c.setStatus(0);
            return c;
        }
        UserinfoExample userinfoExample2 = new UserinfoExample();
        UserinfoExample.Criteria criteria2 = userinfoExample2.createCriteria();
        criteria2.andEmailEqualTo(email);
        List<Userinfo> a2 = userinfoMapper.selectByExample(userinfoExample2);
        if(a2.size() > 0){
            c.setStatus(-1);
            return c;
        }
        else{
            c.setStatus(1);
            return c;
        }
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody Userinfo user){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        user.setValid(1);
        user.setIdentity(0);
        userinfoMapper.insert(user);
        return "Add OK";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUserAll(){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        return userinfoMapper.selectByExample(userinfoExample);
    }

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Userinfo getUserById(@RequestParam String id){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andLogidEqualTo(id);
        List<Userinfo> a = userinfoMapper.selectByExample(userinfoExample);
        return a.get(0);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Login getLogin(@RequestBody Userinfo useri){
        String password = useri.getPassword();
        String username = useri.getLogid();
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andLogidEqualTo(username);
        List<Userinfo> user = userinfoMapper.selectByExample(userinfoExample);
        Login status = new Login();
        if(user.size() == 0){
            status.setIn(0);
            status.setMessage("Invalid");
        }
        else if(user.get(0).getPassword().equals(password)){
            if(user.get(0).getValid().equals(1)){
                status.setIn(1);
                status.setMessage("Ok");
            }
           else{
                status.setIn(2);
                status.setMessage("Forbidden");
            }

        }
        else{
            status.setIn(-1);
            status.setMessage("Wrong");
        }
        return status;
    }
}
