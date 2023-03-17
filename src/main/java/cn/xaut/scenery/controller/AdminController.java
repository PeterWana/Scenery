package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.Admin;
import cn.xaut.scenery.pojo.Comment;
import cn.xaut.scenery.pojo.User;
import cn.xaut.scenery.service.AdminService;
import cn.xaut.scenery.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author wyx
 * @Date 2023/3/14 14:56
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private CommentService commentService;

    //注册
    @PostMapping("/register")
    @ResponseBody
    public Object registerAdmin(@RequestBody Admin admin, HttpSession session){
        ReturnObject returnObject = new ReturnObject();   //根据查询结果生成响应信息
        if(adminService.getAAdminByName(admin.getAdminName()) != null){
            //用户名已存在，不能注册
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在");
        }else {
            //可以注册
            adminService.insertAAdmin(admin);   //注册
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("注册成功");
            Map<String, Admin> newMap = new HashMap<String, Admin>();
            newMap.put(Constants.SESSION_Object, admin);
            returnObject.setInformation((HashMap<?, ?>) newMap);
            session.setAttribute(Constants.SESSION_USER, admin);
        }
        return returnObject;
    }
    //登录
    @PostMapping("/login")
    @ResponseBody
    public Object loginAdmin(@RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword, @RequestParam("isRemPwd") Integer isRemPwd, HttpSession session, HttpServletResponse response){  //形参名和请求的参数名需要相同
        Admin admin = adminService.login(adminName, adminPassword);   //查询用户
        ReturnObject returnObject = new ReturnObject();   //根据查询结果生成响应信息
        if(admin == null){
            //登录失败
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else {
            //登录成功
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("登录成功");
            Map<String, Admin> newMap = new HashMap<String, Admin>();
            newMap.put(Constants.SESSION_Object, admin);
            returnObject.setInformation((HashMap<?, ?>) newMap);
            session.setAttribute(Constants.SESSION_USER, admin);


            //如果需要记住密码，则添加cookie
            if(isRemPwd > 0){
                Cookie cookieUsername = new Cookie("adminName", adminName);
                cookieUsername.setMaxAge(7*24*60*60);   //cookie保存7天
                response.addCookie(cookieUsername);
                Cookie cookiePassword = new Cookie("adminPassword", adminPassword);
                cookieUsername.setMaxAge(7*24*60*60);   //cookie保存7天
                response.addCookie(cookiePassword);
            }else{
                //如果不需要记住密码，则将以前创建的cookie删掉
                Cookie cookieUsername = new Cookie("adminName", null);
                cookieUsername.setMaxAge(0);   //删除cookie
                response.addCookie(cookieUsername);
                Cookie cookiePassword = new Cookie("adminPassword", null);
                cookieUsername.setMaxAge(0);   //删除cookie
                response.addCookie(cookiePassword);
            }
        }
        return returnObject;
    }
    //退出登录
    @RequestMapping("/logout")
    @ResponseBody
    public ReturnObject logout(HttpServletResponse response, HttpSession session){
        ReturnObject returnObject = new ReturnObject();
        //清空cookie
        Cookie cookieUsername = new Cookie("adminName", null);
        cookieUsername.setMaxAge(0);   //删除cookie
        response.addCookie(cookieUsername);
        Cookie cookiePassword = new Cookie("adminPassword", null);
        cookieUsername.setMaxAge(0);   //删除cookie
        response.addCookie(cookiePassword);
        //销毁session
        session.invalidate();
        returnObject.setMessage("退出登录成功");
        return returnObject;   //前端需要重定向到登录前页面
    }

    //查询所有用户
    @GetMapping(value = "/all-user/page/{pageNum}")
    @ResponseBody
    public PageInfo<User> getAllUser(@PathVariable("pageNum") Integer pageNum){
        PageInfo<User> page = adminService.getAllUser(pageNum);
        return page;
    }
    //插入一个用户
    @PostMapping("/user/insert")
    @ResponseBody
    public ReturnObject insertAUser(@RequestBody User user){
        ReturnObject returnObject = new ReturnObject();
        //判断是否存在同名
        if(adminService.getAUserByName(user.getUserName())!=null){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在请重新设置");
        }else{
            try {
                adminService.insertAUser(user);
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("添加成功");
            }catch (Exception e){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("添加失败");
            }
        }
        return returnObject;
    }
    //删除一个用户
    @GetMapping("/user/delete/{userId}")
    @ResponseBody
    public ReturnObject deleteAUser(@PathVariable("userId") Integer userId){
        ReturnObject returnObject = new ReturnObject();
        try {
            adminService.deleteAUserById(userId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //修改一个用户
    @PostMapping("/user/update/{userId}")
    @ResponseBody
    public ReturnObject updateAAdmin(@PathVariable("userId") Integer userId, @RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userSex") Integer userSex, @RequestParam("userAge") Integer userAge, @RequestParam("userNum") String userNum) {
        ReturnObject returnObject = new ReturnObject();
        //判断是否存在同名
        if (adminService.getAUserByName(userName) != null && !Objects.equals(adminService.getAUserById(userId).getUserName(), userName)) {
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在请重新设置");
        } else {
            try {
                adminService.updateAUserById(userId, userName, userPassword, userSex, userAge, userNum);
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("修改成功");
            } catch (Exception e) {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("修改失败");
            }
        }
        return returnObject;
    }
    // 查询一个用户byId
    @GetMapping("user/by-id/{userId}")
    @ResponseBody
    public User getAUserById(@PathVariable("userId") Integer userId){
        return adminService.getAUserById(userId);
    };
    // 查询一个用户byName
    @GetMapping("user/by-name/{userName}")
    @ResponseBody
    public User getAUserByName(@PathVariable("userName") String userName){
        return adminService.getAUserByName(userName);
    };
    //查询所有管理员
    @GetMapping(value = "/all-admin/page/{pageNum}")
    @ResponseBody
    public PageInfo<Admin> getAllAdmin(@PathVariable("pageNum") Integer pageNum){
        PageInfo<Admin> page = adminService.getAllAdmin(pageNum);
        return page;
    }
    //添加一个管理员
    @PostMapping("/insert")
    @ResponseBody
    public ReturnObject insertAAdmin(@RequestBody Admin admin){
        ReturnObject returnObject = new ReturnObject();
        //判断是否存在同名
        if(adminService.getAAdminByName(admin.getAdminName())!=null){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在请重新设置");
        }else{
            try {
                adminService.insertAAdmin(admin);
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("添加成功");
            }catch (Exception e){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("添加失败");
            }
        }
        return returnObject;
    }
    //删除一个管理员
    @GetMapping("/delete/{adminId}")
    @ResponseBody
    public ReturnObject deleteAAdmin(@PathVariable("adminId") Integer adminId){
        ReturnObject returnObject = new ReturnObject();
        try {
            adminService.deleteAAdminById(adminId);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
        return returnObject;
    }
    //修改一个管理员
    @PostMapping("/update/{adminId}")
    @ResponseBody
    public ReturnObject updateAAdmin(@PathVariable("adminId") Integer adminId, @RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword, @RequestParam("adminNum") String adminNum){
        ReturnObject returnObject = new ReturnObject();
        //判断是否存在同名
        if(adminService.getAAdminByName(adminName)!=null && !Objects.equals(adminService.getAAdminById(adminId).getAdminName(), adminName)){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在请重新设置");
        }else {
            try {
                adminService.updateAAdminById(adminId, adminName, adminPassword, adminNum);
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("修改成功");
            } catch (Exception e) {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("修改失败");
            }
        }
        return returnObject;
    }
    //查询一个管理员byId
    @GetMapping("/by-id/{adminId}")
    @ResponseBody
    public Admin getAAdminByName(@PathVariable("adminId") Integer adminId){
        return adminService.getAAdminById(adminId);
    };
    //查询一个管理员byName
    @GetMapping("/by-name/{adminName}")
    @ResponseBody
    public Admin getAAdminByName(@PathVariable("adminName") String adminName){
        return adminService.getAAdminByName(adminName);
    };
    //模糊查找管理员
    @PostMapping(value = "/like/{switchRoute}/page/{pageNum}")
    @ResponseBody
    public PageInfo<?> getAdminByLike(@PathVariable("switchRoute") Integer switchRoute, @PathVariable("pageNum") Integer pageNum, @RequestParam("mohu") String mohu){
       if(switchRoute > 0) {
           //模糊查找管理员
           PageInfo<Admin> page = adminService.getAdminByLike(pageNum, mohu);
           return page;
       }else{
           //模糊查找用户
           PageInfo<User> page = adminService.getUserByLike(pageNum, mohu);
           return page;
       }
    }
    //批量添加用户
    @PostMapping("/insert-more")
    @ResponseBody
    public ReturnObject insertMoreUser(@RequestBody List<User> users){
        ReturnObject returnObject = new ReturnObject();
        try {
            adminService.insertMoreUser(users);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("成功添加" + users.size() + "个用户");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("批量添加失败");
        }
        return returnObject;
    }
    //批量删除用户
    @GetMapping("/delete-more")
    @ResponseBody
    public ReturnObject deleteMoreByArray(@RequestBody List<Integer> userIds){
        ReturnObject returnObject = new ReturnObject();
        try {
            adminService.deleteMoreByArray(userIds);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("成功删除" + userIds.size() + "个用户");
        }catch (Exception e){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("批量删除失败");
        }
        return returnObject;
    }
    //管理员查询所有评论信息
    @GetMapping("/comment/page/{pageNum}")
    @ResponseBody
    public PageInfo<Comment> getAllComent(@PathVariable("pageNum") Integer pageNum){
        PageInfo<Comment> page = commentService.getAllComment(pageNum);
        return page;
    }
}
