package com.glodon.mapper;

import com.glodon.Bean.BO.CityGisModel;
import com.glodon.Bean.BO.GisModel;
import com.glodon.Bean.DangerousHouse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface DangerousHouseDao {
    String TABLE_NAME = " dangerousHouseDao ";
    String INSERT_FIELDS = " `zip_code`, `address`, `count`, `longitude`, `latitude`, `finished`,`inprocess`,`nostart`,`nofound`,`inappropriate`,`proved`";
    String SELECT_FIELDS = " zip_code, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{zipcode},#{address},#{count},#{longitude},#{latitude},#{finished},#{inprocess},#{nostart},#{nofound},#{inappropriate},#{proved})"})
    int addHouseBean(DangerousHouse DangerousHouse);

    @Select("select count(`zip_code`) from dangerousHouse")
    int selectSize();

    @Select("select `longitude` as `lng`,`latitude` as `lat`,`count` from dangerousHouse")
    List<GisModel> selectAllDir();

    @Select("select `longitude` as `lng`,`latitude` as `lat`,`count`,`address` from dangerousHouse")
    List<CityGisModel> selectCityDir();

    /**
     * 批量插入
     *
     * @param DangerousHouse
     * @return
     */
    @InsertProvider(type = DangerousHouseDao.Provider.class, method = "batchInsert")
    int batchInsert(List<DangerousHouse> DangerousHouse);


    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<DangerousHouse> MobileEventss = (List<DangerousHouse>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO dangerousHouse (zip_code, address, count, longitude, latitude,finished,inprocess,nostart,nofound,inappropriate,proved) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].zip_code}, #'{'list[{0}].address}, #'{'list[{0}].count}, #'{'list[{0}].longitude}, #'{'list[{0}].latitude}, " +
                            "#'{'list[{0}].finished}, #'{'list[{0}].inprocess}, #'{'list[{0}].nostart}, #'{'list[{0}].nofound}, #'{'list[{0}].inappropriate}, " +
                            "#'{'list[{0}].proved})"
            );

            for (int i = 0; i < MobileEventss.size(); i++) {
                sb.append(mf.format(new Object[]{i}));
                if (i < MobileEventss.size() - 1)
                    sb.append(",");
            }
            System.out.println(sb.toString());
            return sb.toString();
        }

        /*        *//* 批量删除 *//*
        public String batchDelete(Map map) {
            List<DangerousHouse> MobileEventss = (List<DangerousHouse>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM DangerousHouse WHERE id IN (");
            for (int i = 0; i < MobileEventss.size(); i++) {
                sb.append("'").append(MobileEventss.get(i).getId()).append("'");
                if (i < MobileEventss.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }*/
    }
}

