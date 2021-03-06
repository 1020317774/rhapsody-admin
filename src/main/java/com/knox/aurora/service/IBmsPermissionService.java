package com.knox.aurora.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.knox.aurora.model.entity.UmsPermission;

import java.util.List;

/**
 * 权限接口
 *
 * @author Knox 2020/11/7
 */
public interface IBmsPermissionService extends IService<UmsPermission> {

    /**
     * 根据角色ID查询用户权限
     *
     * @param roleId
     * @return
     */
    List<UmsPermission> getByRoleId(Integer roleId);
}
