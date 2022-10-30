package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.group2.swpgroup2.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // list all category
    public List<Category> findAll();

    // find category by id
    public Category findById(int id);

    // list first 6 category that have hightest numCourse
    public List<Category> findTop6ByOrderByNumCourseDesc();

    // get all category with number of course join with course table
    @Query(value = "SELECT TOP(8) ca.categoryID, ca.category_name, ca.discription, ca.image, COUNT(co.courseID) as num_course FROM Category AS ca LEFT JOIN Course AS co ON ca.categoryID = co.categoryID GROUP BY ca.categoryID, ca.category_name, ca.discription, ca.image ORDER BY num_course DESC", nativeQuery = true)
    public List<Category> getTop8CategoryWithNumCourse();

    //find category by id
    @Query(value = "SELECT * FROM Category WHERE categoryID = ?1", nativeQuery = true)
    public Category findCategoryById(int id);

}
