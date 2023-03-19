package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.Sight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 22:18
 * @Description:
 */
public interface SightMapper {

    //插入一条游览景点信息
    int insertASight(Sight sight);

    //删除一条游览景点信息
    int deleteASight(@Param("sightId") Integer sightId);

    //删除游览景点信息bySightTourId
    int deleteASightBySightTourId(@Param("SightTourId") Integer SightTourId);

    //查询某个游览信息下的所有游览景点信息的sightId
    List<Integer> getAllSightIdBySightTourId(@Param("SightTourId") Integer SightTourId);

}
