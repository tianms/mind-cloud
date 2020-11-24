package com.mind.service.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysRoleRecordModel;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 16:07
 * @Description: 角色操作接口
 */
public interface SysRoleRecordService {

    /**
     * 功能描述: 获取列表
     *
     * @param param
     * @return java.util.List<com.mind.model.sys.SysRoleRecordModel>
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    List<SysRoleRecordModel> queryList(MapUtils param);

    /**
     * 功能描述: 根据id获取详情
     *
     * @param id
     * @return com.mind.model.sys.SysRoleRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    SysRoleRecordModel getById(Integer id);

    /**
     * 功能描述: 新增
     *
     * @param sysRoleRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    Integer insert(SysRoleRecordModel sysRoleRecordModel);

    /**
     * 功能描述: 更新
     *
     * @param sysRoleRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    Integer update(SysRoleRecordModel sysRoleRecordModel);

    /**
     * 功能描述: 根据id删除，逻辑删除
     *
     * @param id
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 13:17
     */
    Integer deleteById(Integer id);

}
