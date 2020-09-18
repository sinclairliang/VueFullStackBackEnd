package com.evan.wj.dto;


import com.evan.wj.dto.base.OutputConverter;
import com.evan.wj.entity.AdminRole;
import com.evan.wj.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserDTO implements OutputConverter<UserDTO, User> {
    private int id;
    private String username;
    private String name;
    private boolean enabled;
    private List<AdminRole> roles;

    public String getUsername() {
        return this.username;
    }

    public void setRoles(List<AdminRole> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AdminRole> getRoles() {
        return roles;
    }
}
