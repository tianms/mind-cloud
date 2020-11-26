package com.mind.dao.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysUserRecordModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/23 16:59
 * @Description: 用户信息
 */
@Mapper
public interface SysUserRecordDao {

    /**
     * 功能描述: 用户列表信息
     *
     * @param mapUtils
     * @return java.util.List<com.mind.model.sys.SysUserRecordModel>
     * @auther: tms
     * @date: 2020/11/23 17:00
     */
    List<SysUserRecordModel> queryList(MapUtils mapUtils);

    /**
     * 功能描述: 根据id获取详情
     *
     * @param id
     * @return com.mind.model.sys.SysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    SysUserRecordModel getById(Integer id);

    /**
     * 功能描述: 新增
     *
     * @param sysUserRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    Integer insert(SysUserRecordModel sysUserRecordModel);

    /**
     * 功能描述: 更新
     *
     * @param sysUserRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    Integer update(SysUserRecordModel sysUserRecordModel);

    /**
     * 功能描述: 删除，逻辑删除
     *
     * @param id
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 09:46
     */
    Integer deleteById(Integer id);

    /**
     * 功能描述: 根据条件查询用户信息
     *
     * @param mapUtils
     * @return com.mind.model.sys.SysUserRecordModel
     * @auther: tms
     * @date: 2020/11/26 16:21
     */
    SysUserRecordModel getByParam(MapUtils mapUtils);
}
