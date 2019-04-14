package com.atguigu.springboot.controller;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookListController {
    private List<Book> bookList = loadList("static/books.json");
    private List<Book> bookList1 = loadList("static/books1.json");

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> all() {
        return bookList;
    }

    @RequestMapping(path = "/ad", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> ad() {
        return bookList1;
    }



    private static List<Book> loadList(String path) {
        List<Book> list = new ArrayList<>();
        try {
            System.out.println("loading");
            Resource resource = new ClassPathResource(path);
            File listFile = resource.getFile();
            JSONArray bookArray = null;

            String input = FileUtils.readFileToString(listFile);

            JSONObject jsonObject = JSONObject.fromObject(input);

            if (jsonObject != null) {
                bookArray = jsonObject.getJSONArray("goodsList");
                list = JSONArray.toList(bookArray, new Book(), new JsonConfig());
            }

        } catch (IOException E) {
            System.out.println("ERROR");
        }
        return list;
    }

}

