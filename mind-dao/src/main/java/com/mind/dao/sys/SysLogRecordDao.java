package com.mind.dao.sys;

import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysLogRecordModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 14:24
 * @Description: 日志持久层
 */
@Mapper
public interface SysLogRecordDao {

    /**
     * 功能描述: 获取列表
     * @param param
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.util.List<com.mind.model.sys.SysLogRecordModel>
    */
    List<SysLogRecordModel> queryList(MapUtils param);

    /**
     * 功能描述: 根据id获取详情
     * @param id
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return com.mind.model.sys.SysLogRecordModel
     */
    SysLogRecordModel getById(Integer id);

    /**
     * 功能描述: 新增
     * @param sysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.lang.Integer
    */
    Integer insert(SysLogRecordModel sysLogRecordModel);

    /**
     * 功能描述: 更新
     * @param sysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return java.lang.Integer
    */
    Integer update(SysLogRecordModel sysLogRecordModel);
}
