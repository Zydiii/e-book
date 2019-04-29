package ebook.controller;

import ebook.dao.UserinfoMapper;
import ebook.entity.Userinfo;
import ebook.entity.UserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    UserinfoMapper userinfoMapper;

    @RequestMapping( path="/users", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUsers(){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        return users;
    }

    @RequestMapping(path = "/changeN", method = RequestMethod.POST)
    @ResponseBody
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

    @RequestMapping(path = "/changeY", method = RequestMethod.POST)
    @ResponseBody
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
