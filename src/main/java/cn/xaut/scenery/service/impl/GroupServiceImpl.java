package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.GroupMapper;
import cn.xaut.scenery.pojo.Group;
import cn.xaut.scenery.service.GroupService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/20 19:24
 * @Description:
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<Group> getAllGroup() {
        return groupMapper.getAllGroup();
    }
}
