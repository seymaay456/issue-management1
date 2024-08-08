package com.temelt.issue_management.service.impl;

import com.temelt.issue_management.repo.UserRepository;
import com.temelt.issue_management.service.UserService;
import com.temelt.issue_management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserServiceImpl() {
    }

    public static UserServiceImpl createUserServiceImpl() {
        return new UserServiceImpl();
    }


    @Override
    public User save(User user) {
        //Business Logic
        if (user.getEmail() == null){
            throw new IllegalArgumentException("User cannot be null!");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
