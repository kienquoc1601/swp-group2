package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.swpgroup2.models.Manager;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    
}
