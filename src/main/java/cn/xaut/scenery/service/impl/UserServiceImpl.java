package cn.xaut.scenery.service.impl;

import cn.xaut.scenery.mapper.UserMapper;
import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.User;
import cn.xaut.scenery.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/13 21:36
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insertUserByRegister(user);
    }

    @Override
    public User login(String userName, String userPassword) {
        return userMapper.getUserByUserNameAndPassword(userName, userPassword);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public int updateUserByUserId(Integer userId, String userName, String userPassword, Integer userSex, Integer userAge, String userNum) {
        return userMapper.updateAUserById(userId, userName, userPassword, userSex, userAge, userNum);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.getAUserById(userId);
    }

}
