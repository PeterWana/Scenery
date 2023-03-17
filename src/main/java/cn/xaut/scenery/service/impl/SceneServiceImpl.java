package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.SceneMapper;
import cn.xaut.scenery.pojo.Scene;
import cn.xaut.scenery.service.SceneService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 13:25
 * @Description:
 */
@Service
@Transactional
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneMapper sceneMapper;

    @Override
    public PageInfo<Scene> getAllScene(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Scene> list = sceneMapper.getAllScene();
        PageInfo<Scene> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public Scene getASceneById(Integer sceneId) {
        return sceneMapper.getASceneById(sceneId);
    }

    @Override
    public int insertAScene(Scene scene) {
        return sceneMapper.insertAScene(scene);
    }

    @Override
    public int deleteASceneById(Integer sceneId) {
        return sceneMapper.deleteASceneById(sceneId);
    }
}
