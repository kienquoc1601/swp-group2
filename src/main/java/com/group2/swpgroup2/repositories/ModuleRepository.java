package com.group2.swpgroup2.repositories;

import org.springframework.stereotype.Repository;
import com.group2.swpgroup2.models.Module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ModuleRepository extends JpaRepository<Module,Integer>{
    //List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
    List<Module> findByChapter(Integer chapterID);
}
