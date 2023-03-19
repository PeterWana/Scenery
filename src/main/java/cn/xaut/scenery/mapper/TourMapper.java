package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.Tour;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 22:18
 * @Description:
 */
public interface TourMapper {

    //插入一条游览信息
    int insertATour(Tour tour);

    //删除一条游览信息
    int deleteATour(@Param("tourId") Integer tourId);

    //查询某个游览信息以及相关的游览景点信息byTourId
    List<Tour> getTourAndSightByTourId(@Param("tourId") Integer tourId);

}
