package com.smh.electroos.service;

import com.smh.electroos.entity.User;
import com.smh.electroos.entity.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
    User createUser(User user, Set<UserRole> userRoles);
}
