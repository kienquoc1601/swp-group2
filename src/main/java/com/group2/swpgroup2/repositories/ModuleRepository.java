package com.group2.swpgroup2.repositories;

import org.springframework.stereotype.Repository;
import com.group2.swpgroup2.models.Module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface ModuleRepository extends JpaRepository<Module,Integer>{
    //List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Module] Where chapterID = ?1 ORDER BY module_num ASC", nativeQuery = true)
    List<Module> findByChapter(Integer chapterID);
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Module] Where moduleID = ?1", nativeQuery = true)
    Module findByID(Integer moduleID);
}
