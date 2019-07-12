package com.glodon.mapper;

import com.glodon.Bean.MobileEvents;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MobileEventsDao {
    String TABLE_NAME = " event ";
    String INSERT_FIELDS = " event_id, device_id, timestamp, longitude, latitude ";
    String SELECT_FIELDS = " event_id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{eventId},#{deviceId},#{timestamp},#{longitude},#{latitude})"})
    int addMobileEvents(MobileEvents mobileEvents);

/*    @Update({"update ", TABLE_NAME, " set status=#{status} where entity_id=#{entityId} and entity_type=#{entityType}"})
    void updateStatus(@Param("entityId") int entityId, @Param("entityType") int entityType, @Param("status") int status);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where event_id=#{eventId} order by id desc"})
    List<MobileEvents> selectByEventId(@Param("eventId") int eventId);

    @Select({"select count(id) from ", TABLE_NAME, " where event_id=#{eventId} "})
    int getEventCount(@Param("eventId") int eventId);*/
}