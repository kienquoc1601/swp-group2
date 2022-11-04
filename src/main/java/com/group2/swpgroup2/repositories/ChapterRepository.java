package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.swpgroup2.models.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Integer> {
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Chapter] Where courseID = ?1 ORDER BY chapter_num ASC", nativeQuery = true)
    List<Chapter> findByCourse(Integer chapterID);
}
