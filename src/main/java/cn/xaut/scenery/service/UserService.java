package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/13 21:36
 * @Description:
 */
public interface UserService {

    int register(User user);

    //用户登录，如果登录失败会返回null
    User login(String userName, String userPassword);

    //判断用户名是否存在，返回true表示用户名已存在，返回false表示用户名可用
    User getUserByUserName(String userName);

    //修改用户信息byId
    int updateUserByUserId(Integer userId, String userName, String userPassword, Integer userSex, Integer userAge, String userNum);

    //查询用户信息byId(可用于数据回显)
    User getUserById(Integer userId);

}
