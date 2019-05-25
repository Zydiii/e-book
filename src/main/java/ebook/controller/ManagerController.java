package ebook.controller;

import ebook.dao.BooksMapper;
import ebook.dao.ItemsMapper;
import ebook.dao.UserinfoMapper;
import ebook.entity.*;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    BooksMapper booksMapper;

    @Autowired
    ItemsMapper itemsMapper;

//    @RequestMapping(path = "/addPic", method = RequestMethod.POST)
//    @ResponseBody
//    public String addPic(@RequestParam(value = "upfile", required = true) MultipartFile[] upfile) throws Exception {
//        Map<String, String> map = new HashMap<String, String>();
//        if (upfile != null && upfile.length > 0) {
//            // 循环获取file数组中得文件
//            for (int i = 0; i < upfile.length; i++) {
//                MultipartFile uploadFile = upfile[i];
//                File source = new File( uploadFile.getOriginalFilename() );// 文件
//                String fileName = uploadFile.getOriginalFilename();
//                uploadFile.transferTo( source );//MultipartFile 转file
//                if (source.isFile()) {
//                    // 得到File后的操作
//                    PicUploader pictureUpload = new PicUploader();
//                    try {
//                        Response res = pictureUpload.upload( source, uploadFile.getOriginalFilename() );
//                        QiniuResponseResult qiniuResponseResult = res.jsonToObject( QiniuResponseResult.class );
//                        map.put( "url", QINIU_IMG_SERVER_URL + qiniuResponseResult.getKey() );
//                        map.put( "name", fileName );
//                        map.put( "size", uploadFile.getSize()+"");
//                        map.put( "state", "SUCCESS" );
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        map.put( "state", "FAIL" );//上传失败
//                    }
//                }
//
//            }
//        }
//
//        System.out.println("OK");
//
//        return "OK";
//    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getBookAll(){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andValidEqualTo(1);
        return booksMapper.selectByExample(booksExample);
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestBody Map<String, String> formData){
        Books newBook = new Books();
        newBook.setCover(formData.get("cover"));
        newBook.setPrice(Float.parseFloat(formData.get("price")));
        newBook.setTitle(formData.get("title"));
        newBook.setShopname(formData.get("shopName"));
        newBook.setWriter(formData.get("writer"));
        newBook.setRemains(Integer.parseInt(formData.get("remains")));
        newBook.setIsbn(formData.get("ISBN"));
        newBook.setIntro(formData.get("intro"));
        newBook.setValid(1);
        newBook.setColor(0);
        newBook.setRemarknum(0);
        newBook.setSalenum(0);
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        newBook.setTime(date);
        booksMapper.insert(newBook);
        return "OK";
    }

    @RequestMapping(path="/sendOrder", method = RequestMethod.GET)
    @ResponseBody
    public String sendOrder(@RequestParam String order_id, @RequestParam int book_id){
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andBookIdEqualTo(book_id).andOrderIdEqualTo(order_id);
        List<Items> o = itemsMapper.selectByExample(itemsExample);
        o.get(0).setState(1);
        itemsMapper.updateByExampleSelective(o.get(0), itemsExample);
        return  "1";
    }

    @RequestMapping(path = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public String updateBook(@RequestBody Books row){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIdEqualTo(row.getId());
        List<Books> o = booksMapper.selectByExample(booksExample);
        booksMapper.updateByExampleSelective(row, booksExample);
        return "OK";
    }

    @RequestMapping(path = "/deleteBook", method = RequestMethod.GET)
    @ResponseBody
    public String delBook(@RequestParam String id){
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        int Id = Integer.parseInt(id);
        criteria.andIdEqualTo(Id);
        List<Books> o = booksMapper.selectByExample(booksExample);
        Books i = new Books();
        i = o.get(0);
        i.setValid(0);
        booksMapper.updateByExampleSelective(i, booksExample);
        return "OK";
    }

    @RequestMapping( path="/users", method = RequestMethod.GET)
    @ResponseBody
    public List<Userinfo> getUsers(){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        return users;
    }

    @RequestMapping(path = "/changeN", method = RequestMethod.POST)
    @ResponseBody
    public List<Userinfo> changeNUsers(@RequestBody Userinfo user){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        //int Id = Integer.parseInt()
        criteria.andIdEqualTo(user.getId());
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        users.get(0).setValid(0);
        userinfoMapper.updateByExampleSelective(users.get(0), userinfoExample);
        return getUsers();
    }

    @RequestMapping(path = "/changeY", method = RequestMethod.POST)
    @ResponseBody
    public List<Userinfo> changeYUsers(@RequestBody Userinfo user){
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andIdEqualTo(user.getId());
        List<Userinfo> users = userinfoMapper.selectByExample(userinfoExample);
        users.get(0).setValid(1);
        userinfoMapper.updateByExampleSelective(users.get(0), userinfoExample);
        return getUsers();
    }
}
