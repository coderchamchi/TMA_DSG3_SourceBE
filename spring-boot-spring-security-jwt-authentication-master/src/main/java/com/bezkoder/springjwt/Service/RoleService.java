package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.entities.ERole;
import com.bezkoder.springjwt.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(ERole roleName);
}
