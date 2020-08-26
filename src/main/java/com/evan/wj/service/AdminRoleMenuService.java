package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleMenuDAO;
import com.evan.wj.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(int rid) {
        return adminRoleMenuDAO.findAllByRid(rid);
    }

    public List<AdminRoleMenu> findAllByRid(List<Integer> rids) {
        return adminRoleMenuDAO.findAllByRidIn(rids);
    }

    public void save(AdminRoleMenu roleMenu) {
        adminRoleMenuDAO.save(roleMenu);
    }

    @Modifying
    @Transactional
    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        adminRoleMenuDAO.deleteByRid(rid);
        List<AdminRoleMenu> roleMenus = new ArrayList<>();
        for (Integer mid : menusIds.get("menusIds")) {
            AdminRoleMenu roleMenu = new AdminRoleMenu();
            roleMenu.setMid(mid);
            roleMenu.setRid(rid);
            roleMenus.add(roleMenu);
        }
        adminRoleMenuDAO.saveAll(roleMenus);
    }
}
