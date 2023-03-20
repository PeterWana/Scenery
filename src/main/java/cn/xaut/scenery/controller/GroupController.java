package cn.xaut.scenery.controller;

import cn.xaut.scenery.pojo.Group;
import cn.xaut.scenery.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/20 19:25
 * @Description:
 */
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    //查询所有群组推荐
    @GetMapping(value = "/reco")
    public List<Group> getAllReco(){
        return groupService.getAllGroup();
    }
}
