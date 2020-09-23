package com.evan.wj.controller;

import com.evan.wj.entity.User;
import com.evan.wj.service.AdminUserRoleService;
import com.evan.wj.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @RequiresPermissions("/api/admin/user")
    @GetMapping("/api/admin/user")
    public List<User> ListUser() throws Exception {
        return userService.list();
    }
}
