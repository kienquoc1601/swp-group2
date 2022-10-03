package com.group2.swpgroup2.repositories;

import org.springframework.stereotype.Repository;
import com.group2.swpgroup2.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Integer>{
    
}
