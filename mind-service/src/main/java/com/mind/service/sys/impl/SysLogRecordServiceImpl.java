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

    @Override
    public List<SysLogRecordModel> queryList(MapUtils param) {
        return sysLogRecordDao.queryList(param);
    }

    @Override
    public SysLogRecordModel getById(Integer id) {
        return sysLogRecordDao.getById(id);
    }

    @Override
    public Integer insert(SysLogRecordModel sysLogRecordModel) {
        return sysLogRecordDao.insert(sysLogRecordModel);
    }

    @Override
    public Integer update(SysLogRecordModel sysLogRecordModel) {
        return sysLogRecordDao.update(sysLogRecordModel);
    }
}
