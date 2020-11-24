package com.mind.service.sys.impl;

import com.mind.common.utils.MapUtils;
import com.mind.dao.sys.SysUserRoleDao;
import com.mind.model.sys.SysUserRoleModel;
import com.mind.service.sys.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 16:02
 * @Description: 用户角色关联操作接口实现层
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 功能描述: 查询列表
     *
     * @param mapUtils
     * @return java.util.List<com.mind.model.sys.SysUserRoleModel>
     * @auther: tms
     * @date: 2020/11/24 15:59
     */
    @Override
    public List<SysUserRoleModel> queryList(MapUtils mapUtils) {
        return sysUserRoleDao.queryList(mapUtils);
    }

    /**
     * 功能描述: 批量插入
     *
     * @param list
     * @return java.lang.Integer
     * @auther: tms
     * @date: 2020/11/24 15:59
     */
    @Override
    public Integer insertBatch(List<SysUserRoleModel> list) {
        return sysUserRoleDao.insertBatch(list);
    }

    /**
     * 功能描述: 根据用户id删除
     *
     * @param userId
     * @return void
     * @auther: tms
     * @date: 2020/11/24 16:00
     */
    @Override
    public void deleteByUserId(Integer userId) {
        sysUserRoleDao.deleteByUserId(userId);
    }

    /**
     * 功能描述: 根据角色id删除
     *
     * @param roleId
     * @return void
     * @auther: tms
     * @date: 2020/11/24 16:00
     */
    @Override
    public void deleteByRoleId(Integer roleId) {
        sysUserRoleDao.deleteByRoleId(roleId);
    }

    /**
     * 功能描述: 去批量插入用户关联角色信息
     *
     * @param roleIdList
     * @param userId
     * @return void
     * @auther: tms
     * @date: 2020/11/24 16:14
     */
    @Override
    public void goInsertBatch(List<Integer> roleIdList, Integer userId) {
        List<SysUserRoleModel> sysUserRoleModelList = new ArrayList<>();
        for (Integer roleId : roleIdList) {
            SysUserRoleModel sysUserRoleModel = new SysUserRoleModel();
            sysUserRoleModel.setRoleId(roleId);
            sysUserRoleModel.setUserId(userId);
            sysUserRoleModelList.add(sysUserRoleModel);
        }
        this.insertBatch(sysUserRoleModelList);
    }
}
