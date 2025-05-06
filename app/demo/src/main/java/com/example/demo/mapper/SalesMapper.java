package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.form.Sales;

@Mapper
public interface SalesMapper {
    
    void insertSales(@Param("sales") Sales sales);

    void insertSalesDetail(@Param("sales") Sales sales);
}
