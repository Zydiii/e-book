package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.BookList;
import com.atguigu.springboot.bean.GoodsDetail;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.GoodsDetailMapper;
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
public class GoodsDetailController {
    @Autowired
    GoodsDetailMapper goodsdetailMapper;

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public List<GoodsDetail> getBookAll(){
        return goodsdetailMapper.getGoodsDetail();
    }




}
