package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.swpgroup2.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    public User findByUsername(String username);
}
