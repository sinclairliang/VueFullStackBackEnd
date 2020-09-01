package com.evan.wj.service;

import com.evan.wj.dao.AdminRolePermissionDAO;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;

    List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDAO.findAllByRid(rid);
    }

    @Transactional
    public void savePermChanges(int rid, List<AdminPermission> perms) {
        adminRolePermissionDAO.deleteAllByRid(rid);
        List<AdminRolePermission> rolePermissions = new ArrayList<>();
        for (int i = 0; i < perms.size(); i++) {
            AdminPermission permission = perms.get(i);
            AdminRolePermission rolePermission = new AdminRolePermission();
            rolePermission.setPid(permission.getId());
            rolePermission.setRid(rid);
            rolePermissions.add(rolePermission);
        }
        adminRolePermissionDAO.saveAll(rolePermissions);
    }
}
