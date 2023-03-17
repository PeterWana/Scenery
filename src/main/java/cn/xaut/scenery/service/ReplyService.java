package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Reply;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wyx
 * @Date 2023/3/17 13:24
 * @Description:
 */
public interface ReplyService {


    //查询回复ById
    Reply getReplyById(Integer replyId);

    //添加一个回复
    int insertAReply(Reply reply);

    //删除一个回复
    int deleteAReplyById(Integer replyId);

    //更新一个回复
    int updateAReplyById(Integer replyId, String replyText);

    //更新点赞byId
    int updateLikeById(Integer replyId);

    //查询点赞数byId
    Integer getLikeById(Integer replyId);
}
