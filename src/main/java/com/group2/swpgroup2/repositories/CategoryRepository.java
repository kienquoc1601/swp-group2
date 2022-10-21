package com.group2.swpgroup2.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group2.swpgroup2.models.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
    //list all category
    public List<Category> findAll();
    //find category by id
    public Category findById(int id);
    //list first 6 category that have hightest numCourse
    public List<Category> findTop6ByOrderByNumCourseDesc();
    
    

}
