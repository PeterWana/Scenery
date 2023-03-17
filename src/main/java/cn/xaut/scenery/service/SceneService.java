package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Scene;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 13:25
 * @Description:
 */
public interface SceneService {

    //查询所有景点
    PageInfo<Scene> getAllScene(Integer pageNum);

    //查询景点ById
    Scene getASceneById(Integer sceneId);

    //添加一个景点
    int insertAScene(Scene scene);

    //删除一个景点
    int deleteASceneById(Integer sceneId);
}
