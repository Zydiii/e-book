package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.BookList;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.BookListMapper;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
public class BookListController1 {

    @Autowired
    BookListMapper booklistMapper;

    @RequestMapping(path = "/all1", method = RequestMethod.GET)
    @ResponseBody
    public List<BookList> getBookAll(){
        return booklistMapper.getBookList();
    }

    @RequestMapping(path = "/ad1", method = RequestMethod.GET)
    @ResponseBody
    public List<BookList> getBookAd(){
        return booklistMapper.getBookList();
    }

}
