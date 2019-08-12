package com.glodon.mapper;

import com.glodon.bean.annotation.Master;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DynamicDao {
    /**
     * 动态传入参数和表名
     *
     * @param column
     * @param table
     * @return
     */
    @Select("select ${column} from ${table} ")
    List<HashMap<String, Object>> selectForMap(@Param("column") String column, @Param("table") String table);

    @Update("create table ${tableName} (${columnMessage})ENGINE=InnoDB DEFAULT CHARSET=utf8")
    void createTable(@Param("columnMessage") String columnMessage, @Param("tableName") String tableName);

    @Insert({"<script>",
            "INSERT into",
            "${tableName}",
            " <foreach collection='params.keys'  item='key' open='(' close=')' separator=',' >",
            "${key}",
            "</foreach>",
            "VALUES",
            " <foreach collection='params.keys'  item='key' open='(' close=')' separator=',' >",
            "'"+"${params[key]}"+"'",
            "</foreach>",
            "</script>"})
    int insertForMap(@Param("params") Map<String, String> params, @Param("tableName") String tableName);

}
