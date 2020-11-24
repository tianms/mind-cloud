package com.mind.service.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysLogRecordModel;
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
     * @param param
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.util.List<com.mind.model.sys.SysUserRecordModel>
     */
    List<SysUserRecordModel> queryList(MapUtils param);

    /**
     * 功能描述: 根据id获取详情
     * @param id
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return com.mind.model.sys.SysUserRecordModel
     */
    SysUserRecordModel getById(Integer id);

    /**
     * 功能描述: 新增
     * @param sysUserRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.lang.Integer
     */
    Integer insert(SysUserRecordModel sysUserRecordModel);

    /**
     * 功能描述: 更新
     * @param sysUserRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return java.lang.Integer
     */
    Integer update(SysUserRecordModel sysUserRecordModel);

    /**
     * 功能描述: 根据id删除，逻辑删除
     * @param id
     * @auther: tms
     * @date: 2020/11/24 13:17
     * @return java.lang.Integer
    */
    Integer deleteById(Integer id);

}
