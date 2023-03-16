package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.Comment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wyx
 * @Date 2023/3/16 21:56
 * @Description:
 */
public interface CommentMapper {

    //插入一条评论
    int insertAComment(Comment comment);

    //删除一条评论
    int deleteACommentById(@Param("comId") Integer comId);

    //更新一条评论
    int updateACommentById(@Param("comId") Integer comId);

    //更新点赞byId
    int updateLikeById(@Param("comId") Integer comId);

    //查询点赞数byId
    Integer getLikeById(@Param("comId") Integer comId);

    //获取评论byId
    String getCommentById(@Param("comId") Integer comId);
}
