package ebook.controller;

import ebook.dao.BooksMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
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

    @Autowired
    BooksMapper booksMapper;

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getBookAll(){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andValidEqualTo(1);
        return booksMapper.selectByExample(booksExample);
    }

    @RequestMapping(path = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public String updateBook(@RequestBody Books row){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIdEqualTo(row.getId());
        List<Books> o = booksMapper.selectByExample(booksExample);
        booksMapper.updateByExampleSelective(row, booksExample);
        return "OK";
    }

    @RequestMapping(path = "/deleteBook", method = RequestMethod.GET)
    @ResponseBody
    public String delBook(@RequestParam String id){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        int Id = Integer.parseInt(id);
        criteria.andIdEqualTo(Id);
        List<Books> o = booksMapper.selectByExample(booksExample);
        Books i = new Books();
        i = o.get(0);
        i.setValid(0);
        booksMapper.updateByExampleSelective(i, booksExample);
        return "OK";
    }

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
