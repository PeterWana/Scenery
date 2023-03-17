package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.Reply;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wyx
 * @Date 2023/3/17 13:24
 * @Description:
 */
public interface ReplyMapper {

    //查询回复ById
    Reply getReplyById(@Param("replyId") Integer replyId);

    //添加一个回复
    int insertAReply(Reply reply);

    //删除一个回复
    int deleteAReplyById(@Param("replyId") Integer replyId);

    //更新一个回复
    int updateAReplyById(@Param("replyId") Integer replyId, @Param("replyText") String replyText);

    //更新点赞byId
    int updateLikeById(@Param("replyId") Integer replyId);

    //查询点赞数byId
    Integer getLikeById(@Param("replyId") Integer replyId);


}
