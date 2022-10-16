package com.group2.swpgroup2.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.CourseStudent;

@Repository
public interface CourseStudentRepo extends JpaRepository<CourseStudent, Integer>{
    public ArrayList<Integer> findByCourseID(int courseID);
    public ArrayList<Integer> findByStudentID(int studentID);  
    
    public CourseStudent findByCourseIDAndStudentID(int courseID, int studentID);

}
