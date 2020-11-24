package com.mind.service.sys.impl;

import com.mind.common.utils.MapUtils;
import com.mind.dao.sys.SysLogRecordDao;
import com.mind.model.sys.SysLogRecordModel;
import com.mind.service.sys.SysLogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 16:12
 * @Description:
 */
@Service("sysLogRecordService")
public class SysLogRecordServiceImpl implements SysLogRecordService {

    @Autowired
    private SysLogRecordDao sysLogRecordDao;

    /**
     * 功能描述: 获取列表
     * @param param
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.util.List<com.mind.model.sys.SysLogRecordModel>
     */
    @Override
    public List<SysLogRecordModel> queryList(MapUtils param) {
        return sysLogRecordDao.queryList(param);
    }

    /**
     * 功能描述: 根据id获取详情
     * @param id
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return com.mind.model.sys.SysLogRecordModel
     */
    @Override
    public SysLogRecordModel getById(Integer id) {
        return sysLogRecordDao.getById(id);
    }

    /**
     * 功能描述: 新增
     * @param sysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.lang.Integer
     */
    @Override
    public Integer insert(SysLogRecordModel sysLogRecordModel) {
        return sysLogRecordDao.insert(sysLogRecordModel);
    }

    /**
     * 功能描述: 更新
     * @param sysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return java.lang.Integer
     */
    @Override
    public Integer update(SysLogRecordModel sysLogRecordModel) {
        return sysLogRecordDao.update(sysLogRecordModel);
    }
}
