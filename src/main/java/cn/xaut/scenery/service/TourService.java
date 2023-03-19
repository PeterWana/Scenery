package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Tour;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 22:18
 * @Description:
 */
public interface TourService {

    //插入一条游览信息
    int insertATour(Tour tour);

    //删除一条游览信息(包含其中的游览景点信息)
    int deleteATour(Integer tourId);

    //查询某个游览信息以及相关的游览景点信息byTourId
    List<Tour> getTourAndSightByTourId(Integer tourId);
}
