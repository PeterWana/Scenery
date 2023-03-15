package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Date:2023/3/13
 * Author:wyx
 * Description:
 */
public interface UserMapper {

    //查询所有用户信息
    List<User> getAllUser();
    //注册, 等同于 int insertAUser(User user);
    int insertUserByRegister(User user);

    //根据用户名查询用户信息
    User getUserByUserName(@Param("userName") String userName);

    //根据用户名和密码查询用户信息
    User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    //删除一个用户byId
    int deleteAUserById(@Param("userId") Integer userId);

    //修改一个用户byId
    int updateAUserById(@Param("userId") Integer userId, @Param("userName") String userName, @Param("userPassword") String userPassword, @Param("userSex") Integer userSex, @Param("userAge") Integer userAge, @Param("userNum") String userNum);

    //修改一个用户byName
    int updateAUserByUserName(@Param("userName") String userName, @Param("userPassword") String userPassword, @Param("userSex") Integer userSex, @Param("userAge") Integer userAge, @Param("userNum") String userNum);

    //查询一个用户byId
    User getAUserById(@Param("userId") Integer userId);

    //查询用户byLike
    List<User> getUserByLike(@Param("mohu") String mohu);

    //批量添加用户
    int insertMoreUser(List<User> users);

    //批量删除用户
    int deleteMoreByArray(int[] user_ids);




}

