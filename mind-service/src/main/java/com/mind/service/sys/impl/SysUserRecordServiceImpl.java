package com.mind.service.sys.impl;

import com.mind.common.constatns.ColumnConstant;
import com.mind.common.constatns.NumConstant;
import com.mind.common.utils.ListUtils;
import com.mind.common.utils.MapUtils;
import com.mind.dao.sys.SysUserRecordDao;
import com.mind.model.sys.SysUserRecordModel;
import com.mind.service.sys.SysUserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
     *
     * @param param
     * @return java.util.List<com.mind.model.sys.SysUserRecordModel>
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    @Override
    public List<SysUserRecordModel> queryList(MapUtils param) {
        return sysUserRecordDao.queryList(param);
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
    public SysUserRecordModel getById(Integer id) {
        return sysUserRecordDao.getById(id);
    }

    /**
     * 功能描述: 新增
     *
     * @param sysLogRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:52
     */
    @Override
    public Integer insert(SysUserRecordModel sysLogRecordModel) {
        sysLogRecordModel.setCreateTime(new Date());
        return sysUserRecordDao.insert(sysLogRecordModel);
    }

    /**
     * 功能描述: 更新
     *
     * @param sysLogRecordModel
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/19 09:53
     */
    @Override
    public Integer update(SysUserRecordModel sysLogRecordModel) {
        sysLogRecordModel.setUpdateTime(new Date());
        return sysUserRecordDao.update(sysLogRecordModel);
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
        return sysUserRecordDao.deleteById(id);
    }

    /**
     * 功能描述: 根据用户名查询同名的用户个数
     *
     * @param userName
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 16:32
     */
    @Override
    public Integer totalByUserName(String userName) {
        MapUtils mapUtils = new MapUtils();
        mapUtils.put(ColumnConstant.EQ_USER_NAME, userName);
        List<SysUserRecordModel> sysUserRecordModelList = this.queryList(mapUtils);
        if (ListUtils.isEmpty(sysUserRecordModelList)) {
            return NumConstant.ZERO;
        } else {
            return sysUserRecordModelList.size();
        }
    }
}
