package com.bezkoder.springjwt.Service.Impl;

import com.bezkoder.springjwt.Service.RoleService;
import com.bezkoder.springjwt.entities.ERole;
import com.bezkoder.springjwt.entities.Role;
import com.bezkoder.springjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
