package com.temelt.issue_management.repo;

import com.temelt.issue_management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);


    User findByUsername(String username);
}
