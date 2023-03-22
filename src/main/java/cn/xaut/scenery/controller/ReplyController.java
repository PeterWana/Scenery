package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.Reply;
import cn.xaut.scenery.service.ReplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author wyx
 * @Date 2023/3/17 13:25
 * @Description:
 */
@RestController
@RequestMapping("/user/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    //查询某一回复ById
    @GetMapping(value = "/{replyId}")
    public Reply getReplyById(@PathVariable("replyId") Integer replyId){
        return replyService.getReplyById(replyId);
    }
    //删除一条回复
    @GetMapping("/delete/{replyId}")
    public ReturnObject deleteAReplyById(@PathVariable("replyId") Integer replyId){
        ReturnObject returnObject = new ReturnObject();
        try {
            replyService.deleteAReplyById(replyId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //添加一条回复
    @PostMapping("/insert")
    public ReturnObject insertAReply(@RequestBody Reply reply){
        ReturnObject returnObject = new ReturnObject();
        try {
            replyService.insertAReply(reply);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("添加成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }
    //更新一条评论,点赞数字默认为0,自动获取系统时间,只需将replyText作为JSON输入
    @PostMapping("/update/{replyId}")
    public ReturnObject updateAReplyById(@PathVariable("replyId") Integer replyId, @RequestParam("replyText") String replyText){
        ReturnObject returnObject = new ReturnObject();
        try {
            replyService.updateAReplyById(replyId, replyText);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("更新成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("更新失败");
        }
        return returnObject;
    }
    //点赞
    @GetMapping("/likes/{replyId}")
    public ReturnObject updateLikeById(@PathVariable("replyId") Integer replyId){
        ReturnObject returnObject = new ReturnObject();
        try {
            replyService.updateLikeById(replyId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("点赞成功");
            returnObject.setInformation(new HashMap<String, Integer>(){{put("当前点赞数", replyService.getLikeById(replyId));}});
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("点赞失败");
        }
        return returnObject;
    }

}
