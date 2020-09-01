package com.evan.wj.service;

import com.evan.wj.dao.AdminPermissionDAO;
import com.evan.wj.dao.AdminRolePermissionDAO;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdminPermissionService {
    @Autowired
    AdminPermissionDAO adminPermissionDAO;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;
    @Autowired
    UserService userService;


    public List<AdminPermission> list() {
        return adminPermissionDAO.findAll();
    }

    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<Integer> pids = adminRolePermissionService
                .findAllByRid(rid)
                .stream()
                .map(AdminRolePermission::getPid)
                .collect(Collectors.toList());
        return adminPermissionDAO.findAllById(pids);
    }

    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream()
                .map(AdminRole::getId)
                .collect(Collectors.toList());

        List<Integer> pids = adminRolePermissionDAO
                .findAllByRid(rids)
                .stream()
                .map(AdminRolePermission::getPid)
                .collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionDAO.findAllById(pids);
        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());
        return URLs;
    }

}
