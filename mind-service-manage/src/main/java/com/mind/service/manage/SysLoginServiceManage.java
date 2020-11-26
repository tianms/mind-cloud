package com.mind.service.manage;

import com.mind.common.exception.BusinessException;
import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysUserRecordModel;
import com.mind.service.sys.SysUserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: tianms
 * @Date: 2020/11/26 15:19
 * @Description: 登录操作管理接口
 */
@Service("sysLoginServiceManage")
public class SysLoginServiceManage {

    @Autowired
    private SysUserRecordService sysUserRecordService;

    /**
     * 功能描述: 登录
     *  1.根据用户名查询用户信息
     *  2.比对密码（密码解密，用输入的密码）
     *  3.获取用户权限
     *  4.生成authKey和sessionId
     * @param userName  用户名
     * @param passWord  密码
     * @param currTime  当前时间
     * @param sessionId sessionId
     * @auther: tms
     * @date: 2020/11/26 15:41
     * @return void
    */
    public MapUtils login (String userName, String passWord, Long currTime, String sessionId) {
        // 1.根据用户名查询用户信息
        SysUserRecordModel sysUserRecordModel = sysUserRecordService.getByUserName(userName);
        if (sysUserRecordModel == null) {
            throw new BusinessException("账号或密码有误");
        }

        // 2.比对密码（密码解密，用输入的密码）
        String decryptPassWord = null; // 根据加密解密算法解密，用当前时间解密
        if (!decryptPassWord.equals(sysUserRecordModel.getPassWord())) {
            throw new BusinessException("账号或密码有误");
        }

        // 3.获取用户权限 todo

        // 4.生成authKey和sessionId
        String authKey = null;
        String newSessionId = null;

        return new MapUtils().put("authKey", authKey).put("sessionId", newSessionId);

    }

}
