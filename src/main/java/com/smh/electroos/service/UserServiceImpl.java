package com.smh.electroos.service;

import com.smh.electroos.entity.User;
import com.smh.electroos.entity.UserRole;
import com.smh.electroos.repository.RoleRepository;
import com.smh.electroos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    private final Logger logger= LoggerFactory.getLogger(UserService.class);

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {

        User isUserExisted = userRepository.findByEmail(user.getEmail());

        if(isUserExisted != null){
            logger.info("Email {} is already registered");
        }
        else{
            for (UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRole().addAll(userRoles);

            userRepository.save(user);
        }

        return user;
    }


}
