package com.ishang.vm.controller;
import com.ishang.vm.result.Result;
import com.ishang.vm.result.ResultFactory;
import com.ishang.vm.service.UserService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.ishang.vm.pojo.User;

import javax.servlet.http.HttpSession;


@Controller
@Api("user相关api")
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @ApiOperation("根据id获取用户信息（用户登录）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",dataType = "int",required = true,value="用户的id",defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或者页面跳转路径错误")
    })
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(username);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    @ApiOperation("新增用户信息（用户注册）")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",name="id",dataType = "int",required = true,value="用户的id",defaultValue = "1")
//    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或者页面跳转路径错误")
    })
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

}

