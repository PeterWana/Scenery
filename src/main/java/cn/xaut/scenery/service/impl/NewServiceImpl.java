package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.NewMapper;
import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.News;
import cn.xaut.scenery.service.NewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/16 11:19
 * @Description:
 */
@Service
@Transactional
public class NewServiceImpl implements NewService {

    @Autowired
    private NewMapper newMapper;

    @Override
    public PageInfo<News> getAllNew(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<News> list = newMapper.getAllNew();
        PageInfo<News> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public int insertANew(News news) {
        return newMapper.insertANew(news);
    }

    @Override
    public int deleteANew(Integer newId) {
        return newMapper.deleteANew(newId);
    }

    @Override
    public int updateLikeById(Integer newId) {
        return newMapper.updateLikeById(newId);
    }

    @Override
    public Integer getLikeById(Integer newId) {
        return newMapper.getLikeById(newId);
    }

}
