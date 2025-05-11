package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.data.Goods;
import java.util.List;

@Mapper
public interface GoodsMapper {
    
    List<Goods> findAll();

    List<Goods> findAllSet(@Param("sequence") String seq);

    boolean existsGoods(@Param("goods") Goods goods);

    int getMaxSeq();

    void insert(@Param("sequence") int seq, @Param("goods") Goods goods);
}
