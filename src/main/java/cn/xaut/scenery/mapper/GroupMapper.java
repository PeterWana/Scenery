package cn.xaut.scenery.mapper;


import cn.xaut.scenery.pojo.Group;
import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/20 19:22
 * @Description:
 */
public interface GroupMapper {

    //查询所有群组推荐
    List<Group> getAllGroup();

}
