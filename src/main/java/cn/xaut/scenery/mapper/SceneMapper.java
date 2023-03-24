package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.Scene;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 13:24
 * @Description:
 */
public interface SceneMapper {

    //查询所有景点
    List<Scene> getAllScene();

    //查询景点ById
    Scene getASceneById(@Param("sceneId") Integer sceneId);

    //添加一个景点
    int insertAScene(Scene scene);

    //删除一个景点
    int deleteASceneById(@Param("sceneId") Integer sceneId);

    //查找景点坐标ById
    String getASceneCoordinateById(@Param("sceneId") Integer sceneId);
}
