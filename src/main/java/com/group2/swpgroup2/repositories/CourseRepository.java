package com.group2.swpgroup2.repositories;

 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    //list 8 course that have hightest rating
    public List<Course> findTop8ByOrderByRatingDesc();
    //@Query("Select x from Course x join Category c where c.category_name = :name")
    //public List<Course> findAllByCategoryName (@Param("category_name")String name);
}
