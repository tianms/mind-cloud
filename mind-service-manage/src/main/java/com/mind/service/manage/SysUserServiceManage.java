package com.mind.service.manage;

import com.mind.common.constatns.NumConstant;
import com.mind.common.exception.BusinessException;
import com.mind.model.sys.SysUserRecordModel;
import com.mind.service.sys.SysUserRecordService;
import com.mind.service.sys.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 14:19
 * @Description: 用户接口操作管理类
 */
@Service("sysUserServiceManage")
public class SysUserServiceManage {

    @Autowired
    private SysUserRecordService sysUserRecordService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 功能描述: 去添加用户信息
     * 1.验证用户名是否存在
     * 2.添加用户信息
     * 3.添加用户关联的角色信息
     *
     * @param sysUserRecordModel
     * @return void
     * @auther: tms
     * @date: 2020/11/24 14:22
     */
    @Transactional(rollbackFor = Exception.class)
    public void goInsert(SysUserRecordModel sysUserRecordModel) {
        // 1.验证用户名是否存在
        Integer userTotal = sysUserRecordService.totalByUserName(sysUserRecordModel.getUserName());
        if (userTotal.intValue() > NumConstant.ZERO.intValue()) {
            throw new BusinessException("用户名重复");
        }

        // 2.添加用户信息
        sysUserRecordService.insert(sysUserRecordModel);

        // 2.添加用户关联的角色信息
        sysUserRoleService.goInsertBatch(sysUserRecordModel.getRoleIdList(), sysUserRecordModel.getId());
    }

    /**
     * 功能描述: 去更新用户信息
     * 1.获取用户信息
     * 2.删除当前用户关联的角色信息
     * 3.更新用户信息
     * 4.添加用户关联的角色信息
     *
     * @param sysUserRecordModel
     * @return void
     * @auther: tms
     * @date: 2020/11/24 14:22
     */
    @Transactional(rollbackFor = Exception.class)
    public void goUpdate(SysUserRecordModel sysUserRecordModel) {
        // 1.获取用户信息
        SysUserRecordModel sysUserModel = sysUserRecordService.getById(sysUserRecordModel.getId());
        if (sysUserModel == null) {
            throw new BusinessException("用户不存在");
        }

        // 2.删除当前用户关联的角色信息
        sysUserRoleService.deleteByUserId(sysUserRecordModel.getId());

        // 3.更新用户信息
        sysUserRecordService.update(sysUserRecordModel);

        // 4.添加用户关联的角色信息
        sysUserRoleService.goInsertBatch(sysUserRecordModel.getRoleIdList(), sysUserRecordModel.getId());
    }

}
