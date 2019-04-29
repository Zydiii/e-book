package ebook.controller;

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
            status.setIn(1);
            status.setMessage("Ok");
        }
        else{
            status.setIn(-1);
            status.setMessage("Wrong");
        }
        return status;
    }
}
