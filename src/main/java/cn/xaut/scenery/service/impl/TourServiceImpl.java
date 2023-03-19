package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.SightMapper;
import cn.xaut.scenery.mapper.TourMapper;
import cn.xaut.scenery.pojo.Tour;
import cn.xaut.scenery.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 22:19
 * @Description:
 */
@Service
@Transactional
public class TourServiceImpl implements TourService {

    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private SightMapper sightMapper;

    @Override
    public int insertATour(Tour tour) {
        return tourMapper.insertATour(tour);
    }

    @Override
    public int deleteATour(Integer tourId) {
        //首先删除tour表中关联tourId的数据
        tourMapper.deleteATour(tourId);
        //其次删除sight表中关联tourId的数据
        sightMapper.deleteASightBySightTourId(tourId);
        return 1;
    }

    @Override
    public List<Tour> getTourAndSightByTourId(Integer tourId) {
        return tourMapper.getTourAndSightByTourId(tourId);
    }


}
