package ebook.controller;

import ebook.entity.Books;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public interface BookListController {
    @RequestMapping(path = "/all1", method = RequestMethod.GET)
    @ResponseBody
    List<Books> getBookAll();
}
