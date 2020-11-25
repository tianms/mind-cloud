package com.mind.manage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mind.common.res.RestResponse;
import com.mind.common.utils.SearchUtil;
import com.mind.manage.req.SysUserRecordReq;
import com.mind.model.sys.SysRoleRecordModel;
import com.mind.service.manage.SysRoleServiceManage;
import com.mind.service.sys.SysRoleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 13:51
 * @Description: 角色操作控制层
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleRecordController {

    @Autowired
    private SysRoleRecordService sysRoleRecordService;

    @Autowired
    private SysRoleServiceManage sysRoleServiceManage;

    /**
     * 功能描述: 角色列表
     *
     * @param req
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:07
     */
    @GetMapping("/queryList")
    public RestResponse queryList(SysUserRecordReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<SysRoleRecordModel> sysRoleRecordModelList = sysRoleRecordService.queryList(SearchUtil.getSearch(req));
        PageInfo<SysRoleRecordModel> pageInfo = new PageInfo<>(sysRoleRecordModelList);
        return RestResponse.success(pageInfo);
    }

    /**
     * 功能描述: 添加角色
     *
     * @param sysRoleRecordModel
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:14
     */
    @PostMapping("/insert")
    public RestResponse insert(@RequestBody SysRoleRecordModel sysRoleRecordModel) {
        sysRoleServiceManage.goInsert(sysRoleRecordModel);
        return RestResponse.success("添加成功");
    }

    /**
     * 功能描述: 添加角色
     *
     * @param sysRoleRecordModel
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:14
     */
    @PostMapping("/update")
    public RestResponse update(@RequestBody SysRoleRecordModel sysRoleRecordModel) {
        sysRoleServiceManage.goUpdate(sysRoleRecordModel);
        return RestResponse.success("更改成功");
    }

    /**
     * 功能描述: 删除角色
     *
     * @param id
     * @return com.mind.common.res.RestResponse
     * @auther: tms
     * @date: 2020/11/24 14:14
     */
    @GetMapping("/delete")
    public RestResponse delete(@RequestParam("id") Integer id) {
        sysRoleRecordService.deleteById(id);
        return RestResponse.success("删除成功");
    }

}
