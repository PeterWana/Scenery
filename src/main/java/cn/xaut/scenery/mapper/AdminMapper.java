package cn.xaut.scenery.mapper;

import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/14 14:50
 * @Description:
 */
public interface AdminMapper {

    //查询所有管理员
    List<Admin> getAllAdmin();

    //插入一个管理员,等同于注册
    int insertAAdmin(Admin admin);

    //根据管理员名和密码查询管理员信息
    Admin getAdminByAdminNameAndPassword(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);

    //删除一个管理员byId
    int deleteAAdminById(@Param("adminId") Integer adminId);

    //修改一个管理员byId
    int updateAAdminById(@Param("adminId") Integer adminId, @Param("adminName") String adminName, @Param("adminPassword") String adminPassword, @Param("adminNum") String adminNum);

    //查询一个管理员byId
    Admin getAAdminById(@Param("adminId") Integer adminId);
    //查询一个管理员byName，检测重名
    Admin getAAdminByName(@Param("adminName") String adminName);
    //查询一个管理员byLike
    List<Admin> getAdminByLike(@Param("mohu") String mohu);
}
