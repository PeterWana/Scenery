package cn.xaut.scenery.service;


import cn.xaut.scenery.pojo.Group;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/20 19:23
 * @Description:
 */
public interface GroupService {

    //查询所有群组推荐
    List<Group> getAllGroup();

    //团登录
    Group login(String groupName, String groupPassword);
}
