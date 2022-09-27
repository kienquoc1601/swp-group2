package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    
}
