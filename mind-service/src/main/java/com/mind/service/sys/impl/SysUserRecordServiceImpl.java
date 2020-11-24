package com.mind.service.sys.impl;

import com.mind.common.utils.MapUtils;
import com.mind.dao.sys.SysUserRecordDao;
import com.mind.model.sys.SysUserRecordModel;
import com.mind.service.sys.SysUserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 16:12
 * @Description: 用户操作接口实现类
 */
@Service("sysUserRecordService")
public class SysUserRecordServiceImpl implements SysUserRecordService {

    @Autowired
    private SysUserRecordDao sysUserRecordDao;

    /**
     * 功能描述: 获取列表
     * @param param
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.util.List<com.mind.model.sys.SysUserRecordModel>
     */
    @Override
    public List<SysUserRecordModel> queryList(MapUtils param) {
        return sysUserRecordDao.queryList(param);
    }

    /**
     * 功能描述: 根据id获取详情
     * @param id
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return com.mind.model.sys.SysLogRecordModel
     */
    @Override
    public SysUserRecordModel getById(Integer id) {
        return sysUserRecordDao.getById(id);
    }

    /**
     * 功能描述: 新增
     * @param sysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:52
     * @return java.lang.Integer
     */
    @Override
    public Integer insert(SysUserRecordModel sysLogRecordModel) {
        return sysUserRecordDao.insert(sysLogRecordModel);
    }

    /**
     * 功能描述: 更新
     * @param sysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     * @return java.lang.Integer
     */
    @Override
    public Integer update(SysUserRecordModel sysLogRecordModel) {
        return sysUserRecordDao.update(sysLogRecordModel);
    }

    /**
     * 功能描述: 根据id删除，逻辑删除
     * @param id
     * @auther: tms
     * @date: 2020/11/24 13:17
     * @return java.lang.Integer
    */
    @Override
    public Integer deleteById(Integer id) {
        return sysUserRecordDao.deleteById(id);
    }
}
