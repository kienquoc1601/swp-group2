package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Answer;


public interface AnswerRepository extends JpaRepository<Answer, Integer>{
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Answer] Where questionid = ?1 ORDER BY date ASC", nativeQuery = true)
    List<Answer> findByQuestion(Integer questionID);
}
