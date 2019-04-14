package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.BookList;
import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookListMapper {

    @Select("select * from BookList")
    public List<BookList> getBookList();

}
