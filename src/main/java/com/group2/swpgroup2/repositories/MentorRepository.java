package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group2.swpgroup2.models.Mentor; 

public interface MentorRepository extends JpaRepository<Mentor , Integer>{
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Mentor] Where mentorID = ?1", nativeQuery = true)
    Mentor findByID(Integer mentorID);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Mentor] Where username = ?1", nativeQuery = true)
    Mentor findByUname(String uname);


}
