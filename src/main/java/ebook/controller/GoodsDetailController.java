package ebook.controller;

import ebook.entity.Books;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public interface GoodsDetailController {
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    Books getBookByID(String ID);
}
