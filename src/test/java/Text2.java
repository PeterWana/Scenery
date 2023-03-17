import cn.xaut.scenery.mapper.CommentMapper;
import cn.xaut.scenery.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 18:04
 * @Description:
 */
public class Text2 {

    @Autowired
    public CommentMapper commentMapper;
    @Test
    public void testSelectAllUser(){
        List<Comment> userList = commentMapper.getCommentBySceneId(1);
        for (Comment comment : userList) {
            System.out.println(comment);
        }
    }

}
