package com.mind.dao.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysUserRoleModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 15:57
 * @Description: 用户关联角色操作持久层
 */
@Mapper
public interface SysUserRoleDao {

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
}
