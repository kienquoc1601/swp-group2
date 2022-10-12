package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
    public Student findByUsername(String username);


}
