package cn.xaut.scenery.service.impl;


import cn.xaut.scenery.mapper.AdminMapper;
import cn.xaut.scenery.mapper.UserMapper;
import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.User;
import cn.xaut.scenery.service.AdminService;
import cn.xaut.scenery.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/14 14:53
 * @Description:
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * pageNum：当前页的页码
     * pageSize：每页显示的条数
     * list：分页之后的数据
     * navigatePages：导航分页的页码数
     * pageNum：当前页的页码
     * pageSize：每页显示的条数
     * size：当前页显示的真实条数
     * total：总记录数
     * pages：总页数
     * prePage：上一页的页码
     * nextPage：下一页的页码
     * isFirstPage/isLastPage：是否为第一页/最后一页
     * hasPreviousPage/hasNextPage：是否存在上一页/下一页
     * navigatePages：导航分页的页码数
     * navigatepageNums：导航分页的页码，[1,2,3,4,5]
     * Examples:
     * PageInfo{
     * pageNum=8, pageSize=4, size=2, startRow=29, endRow=30, total=30, pages=8,
     * list=Page{count=true, pageNum=8, pageSize=4, startRow=28, endRow=32, total=30,
     * pages=8, reasonable=false, pageSizeZero=false},
     * prePage=7, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true,
     * hasNextPage=false, navigatePages=5, navigateFirstPage4, navigateLastPage8,
     * navigatepageNums=[4, 5, 6, 7, 8]
     * }
     */
    @Override
    public PageInfo<User> getAllUser(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<User> list = userMapper.getAllUser();
        PageInfo<User> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public int insertAUser(User user) {
        return userMapper.insertUserByRegister(user);
    }

    @Override
    public int deleteAUserById(Integer userId) {
        return userMapper.deleteAUserById(userId);
    }

    @Override
    public int updateAUserById(Integer userId, String userName, String userPassword, Integer userSex, Integer userAge, String userNum) {
        return userMapper.updateAUserById(userId, userName, userPassword, userSex, userAge, userNum);
    }

    @Override
    public User getAUserById(Integer userId) {
        return userMapper.getAUserById(userId);
    }

    @Override
    public User getAUserByName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public PageInfo<User> getUserByLike(Integer pageNum, String mohu) {
        PageHelper.startPage(pageNum, 10);
        List<User> list = userMapper.getUserByLike(mohu);
        PageInfo<User> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public PageInfo<Admin> getAllAdmin(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Admin> list = adminMapper.getAllAdmin();
        PageInfo<Admin> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public int insertAAdmin(Admin admin) {
        return adminMapper.insertAAdmin(admin);
    }

    @Override
    public Admin login(String adminName, String adminPassword) {
        return adminMapper.getAdminByAdminNameAndPassword(adminName, adminPassword);
    }

    @Override
    public int deleteAAdminById(Integer adminId) {
        return adminMapper.deleteAAdminById(adminId);
    }

    @Override
    public int updateAAdminById(Integer adminId, String adminName, String adminPassword, String adminNum) {
        return adminMapper.updateAAdminById(adminId, adminName, adminPassword, adminNum);
    }

    @Override
    public Admin getAAdminById(Integer adminId) {
        return adminMapper.getAAdminById(adminId);
    }

    @Override
    public Admin getAAdminByName(String adminName){
        return adminMapper.getAAdminByName(adminName);
    };
    @Override
    public PageInfo<Admin> getAdminByLike(Integer pageNum, String mohu) {
        PageHelper.startPage(pageNum, 10);
        List<Admin> list = adminMapper.getAdminByLike(mohu);
        PageInfo<Admin> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public int insertMoreUser(List<User> users) {
        return userMapper.insertMoreUser(users);
    }

    @Override
    public int deleteMoreByArray(List<Integer> userIds) {
        return userMapper.deleteMoreByArray(userIds);
    }


}
