package cn.xaut.scenery.service;

import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/14 14:52
 * @Description:
 */
public interface AdminService {
    //查询所有的用户信息
    PageInfo<User> getAllUser(Integer pageNum);
    //插入一个用户
    int insertAUser(User user);
    //删除一个用户byId
    int deleteAUserById(Integer userId);
    //更新一个用户byId
    int updateAUserById(Integer userId, String userName, String userPassword, Integer userSex, Integer userAge, String userNum);
    //查询一个用户byId
    User getAUserById(Integer userId);
    //查询一个用户byName
    User getAUserByName(String userName);
    //查询用户byLike
    PageInfo<User> getUserByLike(Integer pageNum, String mohu);
    //查询所有的管理员信息
    PageInfo<Admin> getAllAdmin(Integer pageNum);
    //插入一个管理员,注册
    int insertAAdmin(Admin admin);
    //登录
    Admin login(String adminName, String adminPassword);
    //删除一个管理员byId
    int deleteAAdminById(Integer adminId);
    //更新一个管理员byId
    int updateAAdminById(Integer adminId, String adminName, String adminPassword, String adminNum);
    //查询一个管理员byId
    Admin getAAdminById(Integer adminId);
    //查询一个管理员byName
    Admin getAAdminByName(String adminName);
    //查询一个管理员byLike
    PageInfo<Admin> getAdminByLike(Integer pageNum, String mohu);
    //批量添加用户
    int insertMoreUser(List<User> users);
    //批量删除用户
    int deleteMoreByArray(List<Integer> userIds);

}
