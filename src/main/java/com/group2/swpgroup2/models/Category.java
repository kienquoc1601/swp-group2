package com.group2.swpgroup2.models;

// import java.util.HashSet;
// import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID")
    private int categoryID;
    // @ManyToMany(mappedBy = "CourseCategories")
    // private Set<Course> CategoryCourses = new HashSet<>();
    @Column(name = "category_name")
    private String category_name;
    //discription, image, numCourse
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "num_course")
    private int numCourse;
}
