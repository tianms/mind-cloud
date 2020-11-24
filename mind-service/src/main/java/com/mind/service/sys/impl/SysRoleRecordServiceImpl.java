package com.mind.service.sys.impl;

import com.mind.common.utils.MapUtils;
import com.mind.dao.sys.SysRoleRecordDao;
import com.mind.model.sys.SysRoleRecordModel;
import com.mind.service.sys.SysRoleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 16:12
 * @Description: 角色操作接口实现类
 */
@Service("sysRoleRecordService")
public class SysRoleRecordServiceImpl implements SysRoleRecordService {

    @Autowired
    private SysRoleRecordDao sysRoleRecordDao;

    /**
     * 功能描述: 获取列表
     *
     * @param param
     * @return java.util.List<com.mind.model.sys.SysRoleRecordModel>
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    @Override
    public List<SysRoleRecordModel> queryList(MapUtils param) {
        return sysRoleRecordDao.queryList(param);
    }

    /**
     * 功能描述: 根据id获取详情
     *
     * @param id
     * @return com.mind.model.sys.SysLogRecordModel
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    @Override
    public SysRoleRecordModel getById(Integer id) {
        return sysRoleRecordDao.getById(id);
    }

    /**
     * 功能描述: 新增
     *
     * @param sysRoleRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    @Override
    public Integer insert(SysRoleRecordModel sysRoleRecordModel) {
        sysRoleRecordModel.setCreateTime(new Date());
        return sysRoleRecordDao.insert(sysRoleRecordModel);
    }

    /**
     * 功能描述: 更新
     *
     * @param sysRoleRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    @Override
    public Integer update(SysRoleRecordModel sysRoleRecordModel) {
        sysRoleRecordModel.setUpdateTime(new Date());
        return sysRoleRecordDao.update(sysRoleRecordModel);
    }

    /**
     * 功能描述: 根据id删除，逻辑删除
     *
     * @param id
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 13:17
     */
    @Override
    public Integer deleteById(Integer id) {
        return sysRoleRecordDao.deleteById(id);
    }
}
