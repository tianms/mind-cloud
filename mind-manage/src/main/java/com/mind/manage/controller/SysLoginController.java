package com.mind.manage.controller;

import com.mind.common.res.RestResponse;
import com.mind.common.utils.MapUtils;
import com.mind.manage.req.UserFormReq;
import com.mind.service.manage.SysLoginServiceManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tianms
 * @Date: 2020/11/26 14:13
 * @Description: 登录登出接口
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController extends AbstractController {

    @Autowired
    private SysLoginServiceManage sysLoginServiceManage;

    /**
     * 功能描述: 用户登录
     *
     * @param loginFormReq
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/26 17:10
     */
    @PostMapping("/login")
    public RestResponse login(@RequestBody UserFormReq loginFormReq) {
        MapUtils mapUtils = sysLoginServiceManage.login(loginFormReq.getUserName(), loginFormReq.getPassWord(), loginFormReq.getCurrTime(), getSession_Id());
        return RestResponse.success(mapUtils);
    }

    @PostMapping("/logOut")
    public RestResponse logOut() {
        return RestResponse.success("退出完毕");
    }

}
