package ebook.serviceImp;

import ebook.controller.UserInfoController;
import ebook.dao.AddressMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.*;
import ebook.service.BookListService;
import ebook.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    AddressMapper addressMapper;

    public String addAddress(@RequestBody Address newAddress){
        AddressExample addressExample = new AddressExample();
//        AddressExample.Criteria criteria = addressExample.createCriteria();
        newAddress.setValid(1);
        addressMapper.insert(newAddress);
        return "Add OK";
    }

    public String changeAddress(@RequestBody Address change){
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andIdEqualTo(change.getId());
        addressMapper.updateByExampleSelective(change, addressExample);
        return "Change OK";
    }

    public String delAddress(@RequestBody Address del){
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andIdEqualTo(del.getId());
        del.setValid(0);
        addressMapper.updateByExampleSelective(del, addressExample);
        return "Del OK";
    }

    public List<Address> getAddress(@RequestParam String ID){
        int id = Integer.parseInt(ID);
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(id).andValidEqualTo(1);
        return addressMapper.selectByExample(addressExample);
    }

    public Cart checkPhone(@RequestParam String phone){
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

    public String addUser(@RequestBody Userinfo user){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        user.setValid(1);
        user.setIdentity(0);
        userinfoMapper.insert(user);
        return "Add OK";
    }

    public List<Userinfo> getUserAll(){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        return userinfoMapper.selectByExample(userinfoExample);
    }

    public Userinfo getUserById(@RequestParam String id){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andLogidEqualTo(id);
        List<Userinfo> a = userinfoMapper.selectByExample(userinfoExample);
        return a.get(0);
    }

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
