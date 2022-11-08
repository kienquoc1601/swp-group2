package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.faq;
public interface FaqRepository extends JpaRepository<faq, Integer>{
    
}
