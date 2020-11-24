package com.mind.dao.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysRoleRecordModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 14:28
 * @Description: 角色信息持久化
 */
@Mapper
public interface SysRoleRecordDao {

    /**
     * 功能描述: 获取角色列表
     * @param mapUtils
     * @auther: tms
     * @date: 2020/11/24 14:32
     * @return java.util.List<com.mind.model.sys.SysRoleRecordModel>
    */
    List<SysRoleRecordModel> queryList(MapUtils mapUtils);

    /**
     * 功能描述: 根据角色id获取角色信息
     * @param id
     * @auther: tms
     * @date: 2020/11/24 14:32
     * @return com.mind.model.sys.SysRoleRecordModel
    */
    SysRoleRecordModel getById(Integer id);

    /**
     * 功能描述: 添加角色信息
     * @param sysRoleRecordModel
     * @auther: tms
     * @date: 2020/11/24 14:30
     * @return java.lang.Integer
    */
    Integer insert(SysRoleRecordModel sysRoleRecordModel);

    /**
     * 功能描述: 获取角色信息
     * @param sysRoleRecordModel
     * @auther: tms
     * @date: 2020/11/24 14:31
     * @return java.lang.Integer
    */
    Integer update(SysRoleRecordModel sysRoleRecordModel);

    /**
     * 功能描述: 删除，逻辑删除
     * @param id
     * @auther: tms
     * @date: 2020/11/24 09:46
     * @return java.lang.Integer
     */
    Integer deleteById(Integer id);

}
