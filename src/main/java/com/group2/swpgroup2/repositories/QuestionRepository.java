package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Question;

public interface QuestionRepository  extends JpaRepository<Question, Integer>{
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Question] Where courseID = ?1 ORDER BY date ASC", nativeQuery = true)
    List<Question> findByCourse(Integer courseID);
}
