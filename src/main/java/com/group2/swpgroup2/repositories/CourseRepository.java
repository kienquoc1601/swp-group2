package com.group2.swpgroup2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group2.swpgroup2.models.Category;
import com.group2.swpgroup2.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    // list top 8 course have highest rating
    List<Course> findTop3ByOrderByRatingDesc();

    List<Course> findTop8ByOrderByRatingDesc();

    // find course by id
    Course findById(int courseID);

    // find first course have rating highest and have price = 0
    @Query(value = "SELECT TOP (2) * FROM course WHERE price = 0 ORDER BY rating DESC", nativeQuery = true)
    List<Course> findTop2CourseFreeHightestRating();

    @Query(value = "SELECT courseID FROM [CourseStudent] WHERE studentID = ?1", nativeQuery = true)
    List<Integer> findByStudentId(int studentId);

    @Query(value = "INSERT INTO [CourseStudent] (studentID, courseID) VALUES (?1, ?2)", nativeQuery = true)
    void addCourseByStudentId(int studentId, int courseId);

    @Query(value = "SELECT TOP (10) * FROM [OnLearningDB].[dbo].[Category]", nativeQuery = true)
    List<Category> findTop10Category();

    // list course each category
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Course] WHERE categoryID = ?1", nativeQuery = true)
    List<Course> findCourseByCategory(int categoryID);

    //list course order by id desc
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Course] ORDER BY courseID DESC", nativeQuery = true)
    List<Course> findCourseOrderByIdDesc();

    //list featured course each category
    @Query(value = "SELECT TOP(2) c.* FROM [OnLearningDB].[dbo].[Course] as c join [OnLearningDB].[dbo].[CourseStudent] as cs on c.courseID = cs.courseID WHERE c.categoryID = ?1 group by c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, c.num_of_students order by COUNT(*) desc, c.rating desc", nativeQuery = true)
    List<Course> findTop2FeaturedCourseByCategory(int categoryID);

    //list featured course have highest student enroll
    // @Query(value = "SELECT TOP(1) c.* FROM [OnLearningDB].[dbo].[Course] as c join [OnLearningDB].[dbo].[CourseStudent] as cs on c.courseID = cs.courseID group by c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, c.num_of_students order by COUNT(*) desc", nativeQuery = true)
    // List<Course> findFeaturedCourseEnroll();

    //list featured course have highest rating
    // @Query(value = "SELECT TOP(1) c.* FROM [OnLearningDB].[dbo].[Course] as c join [OnLearningDB].[dbo].[CourseStudent] as cs on c.courseID = cs.courseID group by c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, c.num_of_students order by c.rating desc", nativeQuery = true)
    // List<Course> findFeaturedCourseRating();

    // list course with number of students enrolled in each course
    @Query(value = "SELECT s.*, COUNT(cs.courseID) AS 'NumberOfStudents' FROM [OnLearningDB].[dbo].[Course] as s LEFT JOIN [OnLearningDB].[dbo].[CourseStudent] as cs ON s.courseID = cs.courseID GROUP BY s.courseID, s.categoryID, s.course_name, s.course_manager, s.description, s.img_src, s.rating, s.price, c.num_of_students", nativeQuery = true)
    List<Course> findCourseWithNumberOfStudents();

    //find course by name
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Course] WHERE course_name LIKE %?1%", nativeQuery = true)
    Course findByName(String name);

    //find course by id
    @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Course] WHERE courseID = ?1", nativeQuery = true)
    Course findByCourseID(Integer id);

    //get number of student enroll in course
    @Query(value = "SELECT COUNT(*) FROM [OnLearningDB].[dbo].[CourseStudent] WHERE courseID = ?1", nativeQuery = true)
    Integer getNumberOfStudentEnroll(Integer id);

    //list of related courses (same category, not this course)
    @Query(value = "SELECT TOP(3) * FROM [OnLearningDB].[dbo].[Course] WHERE categoryID = ?1 AND courseID != ?2", nativeQuery = true)
    List<Course> findSameCategory(int categoryID, int id);

    // list of course have same Manager (same Manager, not this course)
    @Query(value = "SELECT TOP(3) * FROM [OnLearningDB].[dbo].[Course] WHERE course_manager = ?1 AND courseID != ?2", nativeQuery = true)
    List<Course> findSameManager(int id, int id2);

    // list of course have or contain same name (same name, not this course)
    @Query(value = "SELECT TOP(3) * FROM [OnLearningDB].[dbo].[Course] WHERE course_name LIKE %?1% AND courseID != ?2", nativeQuery = true)
    List<Course> findSameName(String courseName, int id);

    //find all course of student by username
    @Query(value = "SELECT c.* FROM [OnLearningDB].[dbo].[Course] as c join [OnLearningDB].[dbo].[CourseStudent] as cs on c.courseID = cs.courseID join [OnLearningDB].[dbo].[Student] as s on cs.studentID = s.studentID WHERE s.username = ?1", nativeQuery = true)
    List<Course> findAllCourseOfStudent(String username);

    //list all course have name contain keyword
    // @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Course] WHERE course_name LIKE %?1%", nativeQuery = true)
    // List<Course> findCourseByName(String searchCourse);

    //list all course have name contain keyword and courseID = id
    // @Query(value = "SELECT * FROM [OnLearningDB].[dbo].[Course] WHERE course_name LIKE %?1% AND courseID = ?2", nativeQuery = true)
    // List<Course> findCourseByCategoryAndName(String searchCourse, Integer category);

    // list những course có category chứa searchCourse
    @Query(value = "SELECT c.* FROM [OnLearningDB].[dbo].[Course] as c join [OnLearningDB].[dbo].[Category] as ca on c.categoryID = ca.categoryID WHERE ca.category_name LIKE %?1%", nativeQuery = true)
    List<Course> findCourseByCategoryName(String searchCourse);

    // list những course có courseManager name chứa searchCourse
    @Query(value = "SELECT c.* FROM [OnLearningDB].[dbo].[Course] AS c JOIN [OnLearningDB].[dbo].[Manager] AS m ON c.course_manager = m.managerID WHERE m.name LIKE %?1% OR m.org_name LIKE %?1%", nativeQuery = true)
    List<Course> findCourseByCourseManagerName(String searchCourse);

    //list course found by course name, manager name, org name, category name
    // @Query(value = "SELECT c.* FROM [OnLearningDB].[dbo].[Course] AS c JOIN [OnLearningDB].[dbo].[Manager] AS m ON c.course_manager = m.managerID JOIN [OnLearningDB].[dbo].[Category] AS ca ON c.categoryID = ca.categoryID  WHERE c.course_name LIKE %?1% OR m.name LIKE %?1% OR m.org_name LIKE %?1% OR ca.category_name LIKE %?1% ", nativeQuery = true)
    // List<Course> findCourseByAll(String searchCourse);

    //list top 8 course have highest rating
    @Query(value = "SELECT TOP(8) * FROM [OnLearningDB].[dbo].[Course] ORDER BY rating DESC", nativeQuery = true)
    List<Course> findTop8CourseByRating();

    //get all course with number of student enroll
    @Query(value = "SELECT c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY num_of_students DESC", nativeQuery = true)
    List<Course> findAllCourseWithNumberOfStudentEnroll();

    //get all course with number of student enroll order by id desc
    @Query(value = "SELECT c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY c.courseID DESC", nativeQuery = true)
    List<Course> findAllCourseWithNumberOfStudentEnrollOrderByIdDesc();

    //get all course with number of student enroll by category id order by id desc
    @Query(value = "SELECT c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID WHERE c.categoryID = ?1 GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY c.courseID DESC", nativeQuery = true)
    List<Course> findAllCourseWithNumberOfStudentEnrollByCategoryIdOrderByIdDesc(Integer categoryId);

    //get top 1 course with number of student enroll highest
    @Query(value = "SELECT TOP(1) c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY num_of_students DESC", nativeQuery = true)
    List<Course> findTop1CourseWithNumberOfStudentEnrollHighest();

    //get top 1 course with number of student enroll have hightest rating
    @Query(value = "SELECT TOP(1) c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY c.rating DESC", nativeQuery = true)
    List<Course> findTop1CourseWithHighestRating();

    //get all course with number of student enroll have name contain keyword and courseID = id
    @Query(value = "SELECT c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID WHERE c.course_name LIKE %?1% AND c.categoryID = ?2 GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY num_of_students DESC", nativeQuery = true)
    List<Course> findAllCourseWithNumberOfStudentEnrollByNameContainKeywordAndCategoryId(String keyword, Integer categoryId);

    //get all course with number of student enroll have name contain keyword
    @Query(value = "SELECT c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID WHERE c.course_name LIKE %?1% GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY num_of_students DESC", nativeQuery = true)
    List<Course> findAllCourseWithNumberOfStudentEnrollByNameContainKeyword(String keyword);

    //get all course with number of student enroll found by course name, manager name, org name, category name
    @Query(value = "SELECT c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price, COUNT(cs.courseID) as num_of_students FROM Course AS c LEFT JOIN CourseStudent AS cs ON c.courseID = cs.courseID JOIN Manager AS m ON c.course_manager = m.managerID JOIN Category AS ca ON c.categoryID = ca.categoryID WHERE c.course_name LIKE %?1% OR m.name LIKE %?1% OR m.org_name LIKE %?1% OR ca.category_name LIKE %?1% GROUP BY c.courseID, c.categoryID, c.course_name, c.course_manager, c.description, c.img_src, c.rating, c.price ORDER BY num_of_students DESC", nativeQuery = true)
    List<Course> findAllCourseWithNumberOfStudentEnrollFoundByCourseNameManagerNameOrgNameCategoryName(String keyword);

    //update course infomation: categoryID, course_name, course_manager, description, img_src, rating, price
    @Modifying
    @Transactional
    @Query(value = "UPDATE Course SET categoryID = ?1, course_name = ?2, course_manager = ?3, description = ?4, img_src = ?5, rating = ?6, price = ?7 WHERE courseID = ?8", nativeQuery = true)
    int updateCourse(Integer categoryID, String course_name, Integer course_manager, String description, String img_src, Float rating, Float price, Integer courseID);

    //add a new course
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Course (categoryID, course_name, course_manager, description, img_src, rating, price, num_of_students) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, 0)", nativeQuery = true)
	int addCourse(int categoryId, String courseName, int courseManagerId, String courseDescription, String courseImage, float courseRating, float coursePrice);
    
}
