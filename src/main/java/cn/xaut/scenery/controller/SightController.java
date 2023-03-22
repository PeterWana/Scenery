package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.News;
import cn.xaut.scenery.pojo.Sight;
import cn.xaut.scenery.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wyx
 * @Date 2023/3/17 22:20
 * @Description:
 */
@RestController
@RequestMapping("/user/sight")
public class SightController {

    @Autowired
    private SightService sightService;

    //添加一条游览景点信息
    @PostMapping("/insert")
    public ReturnObject insertASight(@RequestBody Sight sight){
        ReturnObject returnObject = new ReturnObject();
        try {
            sightService.insertASight(sight);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("添加成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }

    //删除一条游览景点信息
    @GetMapping("/delete/{sightId}")
    public ReturnObject deleteASight(@PathVariable("sightId") Integer sightId){
        ReturnObject returnObject = new ReturnObject();
        try {
            sightService.deleteASight(sightId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }




}
