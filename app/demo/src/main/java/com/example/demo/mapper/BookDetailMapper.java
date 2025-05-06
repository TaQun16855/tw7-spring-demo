package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.data.BookDetail;

@Mapper
public interface BookDetailMapper {
    
    /**
     * findById
     * @param id 書籍ID
     * @return BookDetail:書籍詳細情報
     */
    @Select(
        """
        SELECT 
            b.context AS "context" 
        FROM 
            book_details b 
        WHERE 
            b.book_id = #{id}           
        """
    )
    @Results(
        id = "bookDetail", value = {
            @Result(property = "context", column = "context")
        }
    )
    BookDetail findById(Integer id);
}
