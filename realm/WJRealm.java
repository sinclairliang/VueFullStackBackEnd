package com.evan.wj.realm;

import java.util.Set;

public class WJRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
    @Autowired
    private AdminPermissionService adminPermissionService;
    @Autowired
    private AdminRoleService adminRoleService;
}