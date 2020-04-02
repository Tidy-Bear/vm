package com.ishang.vm.controller;
import com.ishang.vm.result.Result;
import com.ishang.vm.service.UserService;
import io.swagger.annotations.*;
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
    @ApiOperation("根据id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",dataType = "int",required = true,value="用户的id",defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或者页面跳转路径错误")
    })
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}

