package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.News;
import cn.xaut.scenery.service.NewService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author wyx
 * @Date 2023/3/16 11:19
 * @Description:
 */

@Controller
@RequestMapping("/admin/new")
public class NewController {

    @Autowired
    private NewService newService;

    //查询所有新闻
    @GetMapping(value = "/page/{pageNum}")
    public PageInfo<News> getAllNew(@PathVariable("pageNum") Integer pageNum){
        PageInfo<News> page = newService.getAllNew(pageNum);
        return page;
    }
    //删除一条新闻
    @GetMapping("/delete/{NewId}")
    public ReturnObject deleteANew(@PathVariable("NewId") Integer newId){
        ReturnObject returnObject = new ReturnObject();
        try {
            newService.deleteANew(newId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //添加一条新闻,点赞数字默认为0,自动获取系统时间,只需将newText作为JSON输入
    @PostMapping("/insert")
    @ResponseBody
    public ReturnObject insertANew(@RequestBody News news){
        ReturnObject returnObject = new ReturnObject();
        try {
            newService.insertANew(news);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("添加成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }
    //点赞
    @GetMapping("/likes/{NewId}")
    public ReturnObject updateLikeById(@PathVariable("NewId") Integer newId){
        ReturnObject returnObject = new ReturnObject();
        try {
            newService.updateLikeById(newId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("点赞成功");
            returnObject.setInformation(new HashMap<String, Integer>(){{put("当前点赞数", newService.getLikeById(newId));}});
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("点赞失败");
        }
        return returnObject;
    }
}
