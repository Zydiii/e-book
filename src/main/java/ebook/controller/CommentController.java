package ebook.controller;


import ebook.dao.BooksMapper;
import ebook.dao.ItemsMapper;
import ebook.entity.*;
import ebook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    ItemsMapper itemsMapper;
    @Autowired
    BooksMapper booksMapper;

    @PostMapping("/commentBook")
    @ResponseBody
    public String commentBook(@RequestBody Comment comment){
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andBookIdEqualTo(comment.getBook_id()).andOrderIdEqualTo(comment.getOrder_id());
        List<Items> o = itemsMapper.selectByExample(itemsExample);
        o.get(0).setState(3);
        itemsMapper.updateByExampleSelective(o.get(0), itemsExample);
        mongoTemplate.save(comment);
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria1 = booksExample.createCriteria();
        criteria1.andIdEqualTo(comment.getBook_id());
        List<Books> o1 = booksMapper.selectByExample(booksExample);
        int r = o1.get(0).getRemarknum() + 1;
        o1.get(0).setRemarknum(r);
        booksMapper.updateByExampleSelective(o1.get(0), booksExample);

        return "OK";
    }

    @GetMapping("/getCommentBook")
    @ResponseBody
    public List<Comment> getCommentBook(String ID){
        return commentRepository.findByBookId(Integer.parseInt(ID));
    }



}
