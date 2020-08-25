package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRoleMenu;

import java.util.List;

public interface AdminRoleMenuDAO {
    List<AdminRoleMenu> findAllByRid(int rid);
}
