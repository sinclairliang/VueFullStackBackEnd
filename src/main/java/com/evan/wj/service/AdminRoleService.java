package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleDAO;
import com.evan.wj.pojo.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminMenuService adminMenuService;

//    TODO
//    public List<AdminRole> listWithPermsAndMenus(){}
//    public List<AdminRole> findAll() {}
//    public void addOrUpdate(AdminRole adminRole) {}
//    public List<AdminRole> listRolesByUser(String username) {}
//    public AdminRole updateRoleStatus(AdminRole role) {}
//    public void editRole(@RequestBody AdminRole role)  {}
}
