package com.group2.swpgroup2.repositories;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.group2.swpgroup2.models.Mentor; 

public interface MentorRepository extends JpaRepository<Mentor , Integer>{
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Mentor] Where mentorID = ?1", nativeQuery = true)
    Mentor findByID(Integer mentorID);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Mentor] Where username = ?1", nativeQuery = true)
    Mentor findByUname(String uname);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Mentor] as c join [OnLearningDB].[dbo].[CourseMentor]as cs on c.mentorID = cs.mentorID WHERE cs.courseID = ?1", nativeQuery = true)
    List<Mentor> findByCourse(Integer mentorID);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Mentor (username , name , fullname , img_src , gender, dob , phone ) VALUES (?1, ?2, ?3, ?4, ?5, ?6 , ?7)", nativeQuery = true)
	int addMentor(String username,String name, String Fullname, String ImgSrc, Boolean Gender, Date dob, String phone);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Mentor SET name = ?1, fullname = ?2, img_src = ?3, gender = ?4, dob = ?5, phone = ?6", nativeQuery = true)
    int updateMentor(String name, String Fullname, String ImgSrc, Boolean Gender, Date dob, String phone);
    


}
