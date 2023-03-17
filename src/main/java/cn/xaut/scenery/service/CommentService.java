package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Comment;
import cn.xaut.scenery.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/16 21:56
 * @Description:
 */
public interface CommentService {

    //插入一条评论
    int insertAComment(Comment comment);

    //删除一条评论
    int deleteACommentById(Integer comId);

    //更新一条评论
    int updateACommentById(Integer comId, String comText);

    //更新点赞byId
    int updateLikeById(Integer comId);

    //查询点赞数byId
    Integer getLikeById(Integer comId);

    //获取评论byId
    Comment getCommentById(Integer comId);

    //获取评论bySceneId
    PageInfo<Comment> getCommentBySceneId(Integer sceneId, Integer pageNum);

    //获取评论byUserId
    PageInfo<Comment> getCommentByUserId(Integer userId, Integer pageNum);

    //获取所有评论
    PageInfo<Comment> getAllComment(Integer pageNum);

}
