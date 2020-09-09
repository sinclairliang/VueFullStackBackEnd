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
}
