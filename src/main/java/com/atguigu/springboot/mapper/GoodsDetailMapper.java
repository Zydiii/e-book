package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.GoodsDetail;
import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsDetailMapper {

    @Select("select * from GoodsDetail")
    public List<GoodsDetail> getGoodsDetail();

}
