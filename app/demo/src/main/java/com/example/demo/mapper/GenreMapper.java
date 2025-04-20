package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Genre;

/**
 * xml記法のマッパー
 */
@Mapper
public interface GenreMapper {
    
    /**
     * findById
     * @param code
     * @return　Genre:ジャンル情報
     */
    Genre findById(@Param("code") String code);

    /**
     * findAll
     * @return List Genre:ジャンル情報リスト
     */
    List<Genre> findAll();

}
