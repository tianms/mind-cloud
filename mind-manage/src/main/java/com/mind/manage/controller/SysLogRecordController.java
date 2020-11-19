package com.mind.manage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mind.common.res.RestResponse;
import com.mind.common.utils.SearchUtil;
import com.mind.manage.req.SysLogRecordReq;
import com.mind.model.sys.SysLogRecordModel;
import com.mind.service.sys.SysLogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/19 10:35
 * @Description:
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogRecordController {

    @Autowired
    private SysLogRecordService sysLogRecordService;

    @GetMapping("/queryList")
    public RestResponse queryList (SysLogRecordReq sysLogRecordReq) {
        PageHelper.startPage(1, 10);
        List<SysLogRecordModel> sysLogRecordModels = sysLogRecordService.queryList(SearchUtil.getSearch(sysLogRecordReq));
        PageInfo<SysLogRecordModel> pageInfo = new PageInfo<>(sysLogRecordModels);
        return RestResponse.success(pageInfo);
    }

}
