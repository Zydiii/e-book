package ebook.controller;

import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class GoodsDetailController {

    @Autowired
    BooksMapper booksMapper;

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Books getBookByID(@RequestParam String ID){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        int iD = Integer.parseInt(ID);
        criteria.andIdEqualTo(iD);
        List<Books> b = booksMapper.selectByExample(booksExample);
        return b.get(0);
    }




}
