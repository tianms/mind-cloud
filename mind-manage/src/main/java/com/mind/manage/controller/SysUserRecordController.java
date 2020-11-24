package com.mind.manage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mind.common.constatns.ColumnConstant;
import com.mind.common.res.RestResponse;
import com.mind.common.utils.SearchUtil;
import com.mind.manage.req.SysUserRecordReq;
import com.mind.model.sys.SysUserRecordModel;
import com.mind.service.manage.SysUserServiceManage;
import com.mind.service.sys.SysUserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 13:51
 * @Description: 用户操作控制层
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserRecordController {

    @Autowired
    private SysUserRecordService sysUserRecordService;

    @Autowired
    private SysUserServiceManage sysUserServiceManage;

    /**
     * 功能描述: 用户列表
     *
     * @param req
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:07
     */
    @GetMapping("/queryList")
    public RestResponse queryList(SysUserRecordReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<SysUserRecordModel> sysUserRecordModelList = sysUserRecordService.queryList(SearchUtil.getSearch(req));
        PageInfo<SysUserRecordModel> pageInfo = new PageInfo<>(sysUserRecordModelList);
        return RestResponse.success(pageInfo);
    }

    /**
     * 功能描述: 添加用户
     *
     * @param sysUserRecordModel
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:14
     */
    @PostMapping("/insert")
    public RestResponse insert(@RequestBody  SysUserRecordModel sysUserRecordModel) {
        sysUserServiceManage.goInsert(sysUserRecordModel);
        return RestResponse.success("添加成功");
    }

    /**
     * 功能描述: 添加用户
     *
     * @param sysUserRecordModel
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:14
     */
    @PostMapping("/update")
    public RestResponse update(@RequestBody SysUserRecordModel sysUserRecordModel) {
        sysUserServiceManage.goUpdate(sysUserRecordModel);
        return RestResponse.success("更改成功");
    }

    /**
     * 功能描述: 删除用户
     *
     * @param id
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:14
     */
    @PostMapping("/delete")
    public RestResponse delete(@RequestParam(ColumnConstant.ID) Integer id) {
        sysUserRecordService.deleteById(id);
        return RestResponse.success("删除成功");
    }

}
