package ebook.controllerImp;

import ebook.controller.GoodsDetailController;
import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import ebook.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class GoodsDetailControllerImp implements GoodsDetailController {

    @Autowired
    GoodsDetailService goodsDetailService;

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Books getBookByID(@RequestParam String ID){
        return goodsDetailService.getBookByID(ID);
    }

}
