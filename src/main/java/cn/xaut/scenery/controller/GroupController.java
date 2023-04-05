package cn.xaut.scenery.controller;

import cn.xaut.scenery.common.Constants;
import cn.xaut.scenery.common.ReturnObject;
import cn.xaut.scenery.pojo.Group;
import cn.xaut.scenery.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //登录
    @GetMapping("/group/login")
    public Object loginUser(@RequestParam("groupName") String groupName, @RequestParam("groupPassword") String groupPassword, @RequestParam("isRemPwd") Integer isRemPwd, HttpSession session, HttpServletResponse response){  //形参名和请求的参数名需要相同
        Group group = groupService.login(groupName, groupPassword);   //查询用户
        ReturnObject returnObject = new ReturnObject();   //根据查询结果生成响应信息
        if(group == null){
            //登录失败
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else {
            //登录成功
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("登录成功");
            Map<String, Group> newMap = new HashMap<String, Group>();
            newMap.put(Constants.SESSION_Object, group);
            returnObject.setInformation((HashMap<?, ?>) newMap);
            session.setAttribute(Constants.SESSION_USER, group);

            //如果需要记住密码，则添加cookie
            if(isRemPwd > 0){
                Cookie cookieGroupname = new Cookie("groupName", groupName);
                cookieGroupname.setMaxAge(7*24*60*60);   //cookie保存7天
                response.addCookie(cookieGroupname);
                Cookie cookiePassword = new Cookie("groupPassword", groupPassword);
                cookieGroupname.setMaxAge(7*24*60*60);   //cookie保存7天
                response.addCookie(cookiePassword);
            }else{
                //如果不需要记住密码，则将以前创建的cookie删掉
                Cookie cookieGroupname = new Cookie("groupName", null);
                cookieGroupname.setMaxAge(0);   //删除cookie
                response.addCookie(cookieGroupname);
                Cookie cookiePassword = new Cookie("groupPassword", null);
                cookieGroupname.setMaxAge(0);   //删除cookie
                response.addCookie(cookiePassword);
            }
        }
        return returnObject;
    }
    //退出登录
    @RequestMapping("/group/logout")
    public ReturnObject logout(HttpServletResponse response, HttpSession session){
        ReturnObject returnObject = new ReturnObject();
        //清空cookie
        Cookie cookieGroupname = new Cookie("groupName", null);
        cookieGroupname.setMaxAge(0);   //删除cookie
        response.addCookie(cookieGroupname);
        Cookie cookiePassword = new Cookie("groupPassword", null);
        cookieGroupname.setMaxAge(0);   //删除cookie
        response.addCookie(cookiePassword);
        //销毁session
        session.invalidate();
        returnObject.setMessage("退出登录成功");
        return returnObject;   //前端需要重定向到登录前页面
    }

}
