package com.example.demo.mapper;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Book;

/**
 * アノテーション記法のマッパー
 */
@Mapper
public interface BookMapper {
    
    /**
     * findById
     * @param id 書籍ID
     * @return Optional Book:書籍情報
     */
    @Select(
        """
        SELECT 
            b.id AS "id", 
            b.title AS "title",
            b.author AS "author" 
        FROM 
            books b 
        WHERE 
            b.id = #{id}           
        """
    )
    @Results(
        id = "book", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "author", column = "author"), 
            @Result(property = "detail", column = "id", 
                one = @One(select = "com.example.demo.mapper.BookDetailMapper.findById"))
        }
    )
    Optional<Book> findById(Integer id);


    /**
     * findById
     * @return List Book:書籍情報リスト
     */
    @Select(
        """
        SELECT 
            b.id AS "id", 
            b.title AS "title",
            b.author AS "author" 
        FROM 
            books b           
        """
    )
    @ResultMap("book")
    List<Book> findAll();
}
