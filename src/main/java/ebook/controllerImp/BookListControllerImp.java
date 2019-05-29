package ebook.controllerImp;

import ebook.controller.BookListController;
import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import ebook.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookListControllerImp implements BookListController {

    @Autowired
    BookListService bookListService;

    @RequestMapping(path = "/all1", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getBookAll(){
        return bookListService.getBookAll();
    }
}
