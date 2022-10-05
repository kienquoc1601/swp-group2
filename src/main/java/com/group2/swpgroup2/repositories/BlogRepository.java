package com.group2.swpgroup2.repositories;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group2.swpgroup2.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer>{
    //list all blog
    public List<Blog> findAll();
    //find blog by id
    public Blog findById(int id);
    //list first 10 blog that have hightest rating
    public List<Blog> findTop10ByOrderByRatingDesc();
    //list 5 blog of 5 different category that have most blog
    public List<Blog> findTop5ByOrderByCategoryDesc();
    //list all blog by category
    public List<Blog> findByCategory(String category);
    //list of all blogs in chronological order
    public List<Blog> findAllByOrderByDateDesc();
    //list all blog by category in chronological order
    public List<Blog> findByCategoryOrderByDateDesc(String category);
    //1 blog by title, date post and status 'public'
    public Blog findByTitleAndDateAndStatus(String title, Date date, String status); 

}
    