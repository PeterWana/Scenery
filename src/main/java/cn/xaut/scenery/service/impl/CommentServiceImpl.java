package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.CommentMapper;
import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.Comment;
import cn.xaut.scenery.pojo.User;
import cn.xaut.scenery.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/16 21:56
 * @Description:
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public int insertAComment(Comment comment) {
        return commentMapper.insertAComment(comment);
    }

    @Override
    public int deleteACommentById(Integer comId) {
        return commentMapper.deleteACommentById(comId);
    }

    @Override
    public int updateACommentById(Integer comId, String comText) {
        return commentMapper.updateACommentById(comId, comText);
    }

    @Override
    public int updateLikeById(Integer comId) {
        return commentMapper.updateLikeById(comId);
    }

    @Override
    public Integer getLikeById(Integer comId) {
        return commentMapper.getLikeById(comId);
    }

    @Override
    public Comment getCommentById(Integer comId) {
        return commentMapper.getCommentById(comId);
    }

    @Override
    public PageInfo<Comment> getCommentBySceneId(Integer sceneId, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Comment> list = commentMapper.getCommentBySceneId(sceneId);
        PageInfo<Comment> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public PageInfo<Comment> getCommentByUserId(Integer userId, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Comment> list = commentMapper.getCommentByUserId(userId);
        System.out.println(list);
        PageInfo<Comment> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public PageInfo<Comment> getAllComment(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Comment> list = commentMapper.getAllComment();
        PageInfo<Comment> page = new PageInfo<>(list, 5);
        return page;
    }
}
