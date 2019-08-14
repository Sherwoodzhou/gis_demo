package com.glodon.mapper;

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
    /**
     * 动态查询：通过传入列名+表名，支持任意的查询
     * @param column
     * @param table
     * @return
     */
    @Select("select ${column} from ${table} ")
    List<HashMap<String, Object>> selectForMap(@Param("column") String column, @Param("table") String table);

    /**
     * 动态建表：将文件名作为表名，将列信息读取出来，编写sql语句
     * @param columnMessage
     * @param tableName
     */
    @Update("create table ${tableName} (${columnMessage})ENGINE=InnoDB DEFAULT CHARSET=utf8")
    void createTable(@Param("columnMessage") String columnMessage, @Param("tableName") String tableName);

    /**
     * 动态插入：不使用model的情况，使用foreach加map的方式，添加数据；
     * @param params
     * @param tableName
     * @return
     */
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
