package ebook.serviceImp;

import ebook.controller.GoodsDetailController;
import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import ebook.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class GoodsDetailServiceImp implements GoodsDetailService {

    @Autowired
    BooksMapper booksMapper;

    public Books getBookByID(@RequestParam String ID){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        int iD = Integer.parseInt(ID);
        criteria.andIdEqualTo(iD);
        List<Books> b = booksMapper.selectByExample(booksExample);
        return b.get(0);
    }

}
