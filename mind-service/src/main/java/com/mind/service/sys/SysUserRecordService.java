package com.mind.service.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysUserRecordModel;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 16:07
 * @Description: 用户操作接口
 */
public interface SysUserRecordService {

    /**
     * 功能描述: 获取列表
     *
     * @param param
     * @return java.util.List<com.mind.model.sys.SysUserRecordModel>
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    List<SysUserRecordModel> queryList(MapUtils param);

    /**
     * 功能描述: 根据id获取详情
     *
     * @param id
     * @return com.mind.model.sys.SysUserRecordModel
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
     * 功能描述: 根据id删除，逻辑删除
     *
     * @param id
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 13:17
     */
    Integer deleteById(Integer id);

    /**
     * 功能描述: 根据用户名查询同名的用户个数
     *
     * @param userName
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 16:32
     */
    Integer totalByUserName(String userName);

    /**
     * 功能描述: 根据条件获取用户信息(完全匹配)
     * @param mapUtils
     * @auther: tms
     * @date: 2020/11/26 16:19
     * @return com.mind.model.sys.SysUserRecordModel
    */
    SysUserRecordModel getByParam(MapUtils mapUtils);

    /**
     * 功能描述: 根据用户名查询用户信息
     *
     * @param userName
     * @return com.mind.model.sys.SysUserRecordModel
     * @auther: tms
     * @date: 2020/11/26 16:18
     */
    SysUserRecordModel getByUserName(String userName);

}
