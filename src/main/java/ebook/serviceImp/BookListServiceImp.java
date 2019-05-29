package ebook.serviceImp;

import ebook.controller.BookListController;
import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import ebook.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class BookListServiceImp implements BookListService {

    @Autowired
    BooksMapper booksMapper;

    public List<Books> getBookAll(){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andValidEqualTo(1);
        return booksMapper.selectByExample(booksExample);
    }

}
