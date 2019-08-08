package com.glodon.mapper;

import com.glodon.bean.BO.GisModel;
import com.glodon.bean.MobileEvents;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface MobileEventsDao {
    String TABLE_NAME = " event ";
    String INSERT_FIELDS = " event_id, device_id, timestamp, longitude, latitude ";
    String SELECT_FIELDS = " event_id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{eventId},#{deviceId},#{timestamp},#{longitude},#{latitude})"})
    int addMobileEvents(MobileEvents mobileEvents);

    @Select("select longitude as lng,latitude as lat from event")
    List<GisModel> selectAllDir();
/*
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where event_id=#{eventId} order by id desc"})
    List<MobileEvents> selectByEventId(@Param("eventId") int eventId);
*/


/*    @Update({"update ", TABLE_NAME, " set status=#{status} where entity_id=#{entityId} and entity_type=#{entityType}"})
    void updateStatus(@Param("entityId") int entityId, @Param("entityType") int entityType, @Param("status") int status);

    @Select({"select count(id) from ", TABLE_NAME, " where event_id=#{eventId} "})
    int getEventCount(@Param("eventId") int eventId);*/


    /**
     * 批量插入
     * @param MobileEventss
     * @return
     */
    @InsertProvider(type = Provider.class, method = "batchInsert")
    int batchInsert(List<MobileEvents> MobileEventss);

    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<MobileEvents> MobileEventss = (List<MobileEvents>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO event (event_id, device_id, timestamp, longitude, latitude) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].event_id}, #'{'list[{0}].device_id}, #'{'list[{0}].timestamp}, #'{'list[{0}].longitude}, #'{'list[{0}].latitude})"
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
            List<MobileEvents> MobileEventss = (List<MobileEvents>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM MobileEvents WHERE id IN (");
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
