package com.group2.swpgroup2.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "Course")
//many to one , one to one , default fetch type = eager
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID")
    private int Id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "CourseCategory", 
        joinColumns = @JoinColumn(name = "courseID"), 
        inverseJoinColumns = @JoinColumn(name = "categoryID")
    )
    private Set<Category> CourseCategories = new HashSet<>();
    @Column(name = "course_name")
    private String CourseName;
    //@Column(name = "course_manager")
    @OneToOne
    @JoinColumn(name = "course_manager")
    private Manager CourseManager;
    @Column(name = "description")
    private String Description;
    @Column(name = "img_src")
    private String ImgSrc;
    @Column(name = "rating")
    private float rating;
}
