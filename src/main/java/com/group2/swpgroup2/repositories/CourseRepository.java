package com.group2.swpgroup2.repositories;

 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    //list top 8 course have highest rating
    List<Course> findTop3ByOrderByRatingDesc();
    List<Course> findTop8ByOrderByRatingDesc();

    //find course by id
    Course findById(int courseID);

    //find first course have rating highest and have price = 0
    @Query(value = "SELECT TOP (2) * FROM course WHERE price = 0 ORDER BY rating DESC", nativeQuery = true)
    List<Course> findTop2CourseFreeHightestRating();

    @Query(value = "SELECT courseID FROM [CourseStudent] WHERE studentID = ?1", nativeQuery = true)
    List<Integer> findByStudentId(int studentId);

    @Query(value = "INSERT INTO [CourseStudent] (studentID, courseID) VALUES (?1, ?2)", nativeQuery = true)
    void addCourseByStudentId(int studentId, int courseId);

}
