package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.News;
import cn.xaut.scenery.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/16 11:19
 * @Description:
 */

public interface NewService {

    //查询所有新闻
    PageInfo<News> getAllNew(Integer pageNum);

    //查询新闻ById
    News getNewById(Integer newId);

    //添加一个新闻
    int insertANew(News news);

    //删除一个新闻
    int deleteANew(Integer newId);

    //更新点赞byId
    int updateLikeById(Integer newId);

    //查询点赞byId
    Integer getLikeById(Integer newId);



}
