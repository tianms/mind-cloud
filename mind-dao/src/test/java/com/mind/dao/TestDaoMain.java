package com.mind.dao;

import com.alibaba.fastjson.JSONObject;
import com.mind.common.utils.MapUtils;
import com.mind.dao.sys.SysLogRecordDao;
import com.mind.model.sys.SysLogRecordModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 18:16
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDaoMain {

    @Autowired
    private SysLogRecordDao sysLogRecordDao;

    @Test
    public void test1 () {
        MapUtils map = new MapUtils("id", 1);
        List<SysLogRecordModel> list = sysLogRecordDao.queryList(map);
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void test2 () {
        SysLogRecordModel sysLogRecordModel = new SysLogRecordModel();
        sysLogRecordModel.setCreateTime(new Date());
        sysLogRecordModel.setIp("44444");
        sysLogRecordModel.setMethod("methods~");
        sysLogRecordModel.setUserName("哈哈哈哈");
        sysLogRecordModel.setParams("{444444}");
        sysLogRecordModel.setRunTime(new BigDecimal(444444));
        sysLogRecordModel.setOperation("44444");
        sysLogRecordDao.insert(sysLogRecordModel);
    }

}
