package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.User;
import cn.xaut.scenery.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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
 * @Date 2023/3/13 16:02
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")
    @ResponseBody
    public Object registerUser(@RequestBody User user, HttpSession session){
        ReturnObject returnObject = new ReturnObject();   //根据查询结果生成响应信息
        if(userService.getUserByUserName(user.getUserName()) != null){
            //用户名已存在，不能注册
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在");
        }else {
            //可以注册
            userService.register(user);   //注册
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("注册成功");
            Map<String, User> newMap = new HashMap<String, User>();
            newMap.put(Constants.SESSION_Object, user);
            returnObject.setInformation((HashMap<?, ?>) newMap);
            session.setAttribute(Constants.SESSION_USER, user);
        }
        return returnObject;
    }
    //登录/ 团与用户共有
    @PostMapping("/login")
    @ResponseBody
    public Object loginUser(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("isRemPwd") Integer isRemPwd, HttpSession session, HttpServletResponse response){  //形参名和请求的参数名需要相同
        User user = userService.login(userName, userPassword);   //查询用户
        ReturnObject returnObject = new ReturnObject();   //根据查询结果生成响应信息
        if(user == null){
            //登录失败
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else {
            //登录成功
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("登录成功");
            Map<String, User> newMap = new HashMap<String, User>();
            newMap.put(Constants.SESSION_Object, user);
            returnObject.setInformation((HashMap<?, ?>) newMap);
            session.setAttribute(Constants.SESSION_USER, user);


            //如果需要记住密码，则添加cookie
            if(isRemPwd > 0){
                Cookie cookieUsername = new Cookie("userName", userName);
                cookieUsername.setMaxAge(7*24*60*60);   //cookie保存7天
                response.addCookie(cookieUsername);
                Cookie cookiePassword = new Cookie("userPassword", userPassword);
                cookieUsername.setMaxAge(7*24*60*60);   //cookie保存7天
                response.addCookie(cookiePassword);
            }else{
                //如果不需要记住密码，则将以前创建的cookie删掉
                Cookie cookieUsername = new Cookie("userName", null);
                cookieUsername.setMaxAge(0);   //删除cookie
                response.addCookie(cookieUsername);
                Cookie cookiePassword = new Cookie("userPassword", null);
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
        Cookie cookieUsername = new Cookie("userName", null);
        cookieUsername.setMaxAge(0);   //删除cookie
        response.addCookie(cookieUsername);
        Cookie cookiePassword = new Cookie("userPassword", null);
        cookieUsername.setMaxAge(0);   //删除cookie
        response.addCookie(cookiePassword);
        //销毁session
        session.invalidate();
        returnObject.setMessage("退出登录成功");
        return returnObject;   //前端需要重定向到登录前页面
    }
    //查询用户信息byId(可用于数据回显)
    @GetMapping("/by-id/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable("userId") Integer userId){
        return userService.getUserById(userId);
    }
    //修改用户信息ById
    @PostMapping("/update/{userId}")
    @ResponseBody
    public ReturnObject updateAUserById(@PathVariable("userId") Integer userId, @RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userSex") Integer userSex, @RequestParam("userAge") Integer userAge, @RequestParam("userNum") String userNum){
        ReturnObject returnObject = new ReturnObject();

        //判断是否存在同名
        if(userService.getUserByUserName(userName)!=null && !Objects.equals(userService.getUserById(userId).getUserName(), userName)){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名已存在请重新设置");
        }else {
            try {
                userService.updateUserByUserId(userId, userName, userPassword, userSex, userAge, userNum);
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("修改成功");
            } catch (Exception e) {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("修改失败");
            }
        }
        return returnObject;
    }

    //个人推荐
    @GetMapping("/recommend/{userId}")
    @ResponseBody
    public List<User> getRecommendByUserId(@PathVariable("userId") Integer userId){
        return userService.getRecommendByUserId(userId);
    }

//    //测试渲染主页
//    @RequestMapping(value = "/")
//    public String index(){
//        return "index";
//    }

}


