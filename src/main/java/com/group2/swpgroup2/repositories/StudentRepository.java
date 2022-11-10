package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
    public Student findByUsername(String username);

    //find student by username
    @Query(value = "SELECT TOP 1 [studentID], [username], [fullname], [img_src], [gender], [dob] FROM [OnLearningDB].[dbo].[Student] WHERE username = ?1", nativeQuery = true)
    Student findStudentByUsername(String username);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Student] as c join [OnLearningDB].[dbo].[CourseStudent]as cs on c.studentID = cs.studentID WHERE cs.courseID = ?1", nativeQuery = true)
    List<Student> findByCourse(Integer courseID);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Student] WHERE studentID = ?1", nativeQuery = true)
    Student findByID(Integer studentID);

}
