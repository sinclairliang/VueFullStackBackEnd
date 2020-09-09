package com.evan.wj.dao;

import com.evan.wj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
