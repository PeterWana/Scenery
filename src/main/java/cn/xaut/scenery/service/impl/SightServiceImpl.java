package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.SightMapper;
import cn.xaut.scenery.pojo.Sight;
import cn.xaut.scenery.service.SightService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wyx
 * @Date 2023/3/17 22:19
 * @Description:
 */
@Service
@Transactional
public class SightServiceImpl implements SightService {

    @Autowired
    private SightMapper sightMapper;

    @Override
    public int insertASight(Sight sight) {
        return sightMapper.insertASight(sight);
    }

    @Override
    public int deleteASight(Integer sightId) {
        return sightMapper.deleteASight(sightId);
    }
}
