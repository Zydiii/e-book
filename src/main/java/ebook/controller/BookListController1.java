package ebook.controller;

import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookListController1 {

    @Autowired
    BooksMapper booksMapper;

    @RequestMapping(path = "/all1", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getBookAll(){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andValidEqualTo(1);
        return booksMapper.selectByExample(booksExample);
    }

//    @RequestMapping(path = "/ad1", method = RequestMethod.GET)
//    @ResponseBody
//    public List<BookList> getBookAd(){
//        return booklistMapper.getBookList();
//    }

}
