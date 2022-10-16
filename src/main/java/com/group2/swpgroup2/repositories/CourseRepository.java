package com.group2.swpgroup2.repositories;

//import java.util.ArrayList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    //list top 8 course have highest rating
    List<Course> findTop3ByOrderByRatingDesc();
    List<Course> findTop8ByOrderByRatingDesc();
}
