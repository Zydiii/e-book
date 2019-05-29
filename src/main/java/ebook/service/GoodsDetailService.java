package ebook.service;

import ebook.entity.Books;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public interface GoodsDetailService {
    public Books getBookByID(String ID);
}
