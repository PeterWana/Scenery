package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.Tour;
import cn.xaut.scenery.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 22:19
 * @Description:
 */
@RestController
@RequestMapping("/user/tour")
public class TourController {

    @Autowired
    private TourService tourService;

    //添加一条游览信息
    @PostMapping("/insert")
    public ReturnObject insertATour(@RequestBody Tour tour){
        ReturnObject returnObject = new ReturnObject();
        try {
            tourService.insertATour(tour);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("添加成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }

    //删除一条游览信息，包括其中的游览景点信息
    @GetMapping("/delete/{tourId}")
    public ReturnObject deleteANew(@PathVariable("tourId") Integer tourId){
        ReturnObject returnObject = new ReturnObject();
        try {
            tourService.deleteATour(tourId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //查询某个游览信息以及相关的游览景点信息byTourId
    @GetMapping("/{tourId}")
    public Object getTourAndSight(@PathVariable("tourId") Integer tourId){
        try {
            return tourService.getTourAndSightByTourId(tourId);
        }catch (Exception e){
            return new ReturnObject(){
                @Override
                public void setMessage(String message) {
                    super.setMessage("查找失败");
                }
            };
        }
    }


}
