package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.ReplyMapper;
import cn.xaut.scenery.pojo.Reply;
import cn.xaut.scenery.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wyx
 * @Date 2023/3/17 13:25
 * @Description:
 */
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public Reply getReplyById(Integer replyId) {
        return replyMapper.getReplyById(replyId);
    }

    @Override
    public int insertAReply(Reply reply) {
        return replyMapper.insertAReply(reply);
    }

    @Override
    public int deleteAReplyById(Integer replyId) {
        return replyMapper.deleteAReplyById(replyId);
    }

    @Override
    public int updateAReplyById(Integer replyId, String replyText) {
        return replyMapper.updateAReplyById(replyId, replyText);
    }

    @Override
    public int updateLikeById(Integer replyId) {
        return replyMapper.updateLikeById(replyId);
    }

    @Override
    public Integer getLikeById(Integer replyId) {
        return replyMapper.getLikeById(replyId);
    }
}
