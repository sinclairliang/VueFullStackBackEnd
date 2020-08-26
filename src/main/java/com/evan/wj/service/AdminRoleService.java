package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleDAO;
import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<AdminRole> listWithPermsAndMenus() {
        List<AdminRole> allRoles = adminRoleDAO.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (int i = 0; i < allRoles.size(); i++) {
            AdminRole role = allRoles.get(i);
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return allRoles;

    }

    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.getByName(username).getId();
        List<Integer> rids = adminUserRoleService
                .listAllByUid(uid)
                .stream()
                .map(AdminUserRole::getId)
                .collect(Collectors.toList());

        return adminRoleDAO.findAllById(rids);
    }
//    public List<AdminRole> findAll() {}
//    public void addOrUpdate(AdminRole adminRole) {}
//    public AdminRole updateRoleStatus(AdminRole role) {}
//    public void editRole(@RequestBody AdminRole role)  {}
}
