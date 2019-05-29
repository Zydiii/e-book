package ebook.service;

import ebook.entity.Address;
import ebook.entity.Cart;
import ebook.entity.Login;
import ebook.entity.Userinfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public interface UserInfoService {
    public String addAddress(Address newAddress);
    public String changeAddress(Address change);
    public String delAddress(Address del);
    public List<Address> getAddress(String ID);
    public Cart checkPhone(String phone);
    public Cart check(String logid, String email);
    public String addUser(Userinfo user);
    public List<Userinfo> getUserAll();
    public Userinfo getUserById(String id);
    public Login getLogin(Userinfo useri);
}
