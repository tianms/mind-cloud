package com.mind.service.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysUserRoleModel;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 16:01
 * @Description: 用户角色关联操作接口
 */
public interface SysUserRoleService {

    /**
     * 功能描述: 查询列表
     *
     * @param mapUtils
     * @return java.util.List<com.mind.model.sys.SysUserRoleModel>
     * @auther: tms
     * @date: 2020/11/24 15:59
     */
    List<SysUserRoleModel> queryList(MapUtils mapUtils);

    /**
     * 功能描述: 批量插入
     *
     * @param list
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 15:59
     */
    Integer insertBatch(List<SysUserRoleModel> list);

    /**
     * 功能描述: 根据用户id删除
     *
     * @param userId
     * @return void
     * @auther: tms
     * @date: 2020/11/24 16:00
     */
    void deleteByUserId(Integer userId);

    /**
     * 功能描述: 根据角色id删除
     *
     * @param roleId
     * @return void
     * @auther: tms
     * @date: 2020/11/24 16:00
     */
    void deleteByRoleId(Integer roleId);

    /**
     * 功能描述: 去批量插入用户关联角色信息
     *
     * @param roleIdList
     * @param userId
     * @return void
     * @auther: tms
     * @date: 2020/11/24 16:14
     */
    void goInsertBatch(List<Integer> roleIdList, Integer userId);
}
