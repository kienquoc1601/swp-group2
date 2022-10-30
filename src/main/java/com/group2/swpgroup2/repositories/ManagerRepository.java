package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group2.swpgroup2.models.Manager;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    
    //get manager by id
    @Query(value = "SELECT * FROM manager WHERE id = ?1", nativeQuery = true)
    Manager getAllManagerById(int id);

    //get all manager
    @Query(value = "SELECT * FROM manager", nativeQuery = true)
    List<Manager> getAllManager();
}
