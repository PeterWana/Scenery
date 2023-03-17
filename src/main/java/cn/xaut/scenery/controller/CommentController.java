package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.Comment;
import cn.xaut.scenery.pojo.News;
import cn.xaut.scenery.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author wyx
 * @Date 2023/3/16 21:57
 * @Description:
 */
@RestController
@RequestMapping(value = "/user/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    //添加一条评论
    @PostMapping("/insert")
    public ReturnObject insertAComment(@RequestBody Comment comment){
        ReturnObject returnObject = new ReturnObject();
        try {
            commentService.insertAComment(comment);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("评论成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("评论失败");
        }
        return returnObject;
    }
    //删除一条评论
    @GetMapping("/delete/{comId}")
    public ReturnObject deleteAComment(@PathVariable("comId") Integer comId){
        ReturnObject returnObject = new ReturnObject();
        try {
            commentService.deleteACommentById(comId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //更新一条评论,点赞数字默认为0,自动获取系统时间,只需将comText作为JSON输入
    @PostMapping("/update/{comId}")
    public ReturnObject updateAComment(@PathVariable("comId") Integer comId, @RequestParam("comText") String comText){
        ReturnObject returnObject = new ReturnObject();
        try {
            commentService.updateACommentById(comId, comText);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("更新成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("更新失败");
        }
        return returnObject;
    }
    //点赞
    @GetMapping("/likes/{comId}")
    public ReturnObject updateLikeById(@PathVariable("comId") Integer comId){
        ReturnObject returnObject = new ReturnObject();
        try {
            commentService.updateLikeById(comId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("点赞成功");
            returnObject.setInformation(new HashMap<String, Integer>(){{put("当前点赞数", commentService.getLikeById(comId));}});
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("点赞失败");
        }
        return returnObject;
    }
    //查询评论ById
    @GetMapping("/{comId}")
    public Comment getCommentById(@PathVariable("comId") Integer comId){
        return commentService.getCommentById(comId);
    }
    //查询某个景点下的评论
    @GetMapping("/scene/{sceneId}/page/{pageNum}")
    public PageInfo<Comment> getCommentBySceneId(@PathVariable("sceneId") Integer sceneId, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Comment> page = commentService.getCommentBySceneId(sceneId, pageNum);
        return page;
    }
    //查询某个用户下的评论
    @GetMapping("/user/{userId}/page/{pageNum}")
    public PageInfo<Comment> getCommentByUserId(@PathVariable("userId") Integer userId, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Comment> page = commentService.getCommentByUserId(userId, pageNum);
        return page;
    }


}
