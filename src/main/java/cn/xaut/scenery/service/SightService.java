package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Sight;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wyx
 * @Date 2023/3/17 22:19
 * @Description:
 */
public interface SightService {

    //插入一条游览景点信息
    int insertASight(Sight sight);

    //删除一条游览景点信息
    int deleteASight(Integer sightId);

}
