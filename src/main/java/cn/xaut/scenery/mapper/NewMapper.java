package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/16 11:18
 * @Description:
 */
public interface NewMapper {

    //查询所有新闻
    List<News> getAllNew();

    //查询新闻ById
    News getNewById(@Param("newId") Integer newId);

    //添加一个新闻
    int insertANew(News news);

    //删除一个新闻
    int deleteANew(@Param("newId") Integer newId);

    //更新点赞byId
    int updateLikeById(@Param("newId") Integer newId);

    //查询点赞数byId
    Integer getLikeById(@Param("newId") Integer newId);

}
