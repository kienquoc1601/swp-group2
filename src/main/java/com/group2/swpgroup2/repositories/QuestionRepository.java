package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Question;

public interface QuestionRepository  extends JpaRepository<Question, Integer>{
    
}
