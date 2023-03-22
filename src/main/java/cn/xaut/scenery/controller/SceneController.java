package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.Scene;
import cn.xaut.scenery.service.SceneService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wyx
 * @Date 2023/3/17 13:26
 * @Description:
 */
@RestController
@RequestMapping("/admin/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    //查询所有景点
    @GetMapping(value = "/page/{pageNum}")
    public PageInfo<Scene> getAllNew(@PathVariable("pageNum") Integer pageNum){
        PageInfo<Scene> page = sceneService.getAllScene(pageNum);
        return page;
    }
    //查询某一景点ById
    @GetMapping(value = "/{sceneId}")
    public Scene getSceneById(@PathVariable("sceneId") Integer sceneId){
        return sceneService.getASceneById(sceneId);
    }
    //删除一个景点
    @GetMapping("/delete/{sceneId}")
    public ReturnObject deleteASceneById(@PathVariable("sceneId") Integer sceneId){
        ReturnObject returnObject = new ReturnObject();
        try {
            sceneService.deleteASceneById(sceneId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //添加一个景点
    @PostMapping("/insert")
    public ReturnObject insertAScene(@RequestBody Scene scene){
        ReturnObject returnObject = new ReturnObject();
        try {
            sceneService.insertAScene(scene);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("添加成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }
    //根据001-002-003, Id形式得到景点
    @GetMapping(value = "route/{sceneRoute}")
    public Map<Integer, Object> getSceneById(@PathVariable("sceneRoute") String sceneRoute){
        String sceneRoutePro[] = sceneRoute.split("-");
        Map<Integer, Object> map = new HashMap<>();
        for(int i=0; i<sceneRoutePro.length; i++){
//            System.out.println(sceneRoutePro[i]);
            map.put(Integer.parseInt(sceneRoutePro[i]), sceneService.getASceneById(Integer.parseInt(sceneRoutePro[i])));
        }
        return map;
    }
}
