package com.glodon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DynamicDao {
    /**
     * 动态传入参数和表名
     * @param column
     * @param table
     * @return
     */
    @Select("select ${column} from ${table} ")
    List<HashMap<String,Object>> selectForMap(@Param("column")String column, @Param("table")String table);
}
