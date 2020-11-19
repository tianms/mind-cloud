package com.mind.service;

import com.alibaba.fastjson.JSONObject;
import com.mind.common.utils.MapUtils;
import com.mind.model.sys.SysLogRecordModel;
import com.mind.service.sys.SysLogRecordService;
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
 * @Date: 2020/11/19 09:29
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MindServiceApplication.class)
public class TestServiceMain {

    @Autowired
    private SysLogRecordService sysLogRecordService;

    @Test
    public void test1 () {
        MapUtils map = new MapUtils("id", 1);
        List<SysLogRecordModel> list = sysLogRecordService.queryList(map);
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void test2 () {
        SysLogRecordModel sysLogRecordModel = new SysLogRecordModel();
        sysLogRecordModel.setCreateTime(new Date());
        sysLogRecordModel.setIp("55555");
        sysLogRecordModel.setMethod("methods~");
        sysLogRecordModel.setUserName("哈哈哈哈");
        sysLogRecordModel.setParams("{55555}");
        sysLogRecordModel.setRunTime(new BigDecimal(55555));
        sysLogRecordModel.setOperation("55555");
        sysLogRecordService.insert(sysLogRecordModel);
    }
}
