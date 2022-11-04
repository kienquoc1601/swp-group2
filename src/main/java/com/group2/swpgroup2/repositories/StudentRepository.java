package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
    public Student findByUsername(String username);

    //find student by username
    @Query(value = "SELECT [studentID], [username], [fullname], [img_src], [gender], [dob] FROM [OnLearningDB].[dbo].[Student] WHERE username = ?1", nativeQuery = true)
    Student findStudentByUsername(String username);

}
