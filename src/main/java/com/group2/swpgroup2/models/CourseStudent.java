package com.group2.swpgroup2.models;
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
@Table(name = "CourseStudent")
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @OneToOne(mappedBy = "course")
    // @JoinColumn(name = "courseID")
    // private Course course;
    // @OneToOne(mappedBy = "student")
    // @JoinColumn(name = "studentID")
    // private Student student;

    @Column(name = "courseID")
    private int courseID;
    @Column(name = "studentID")
    private int studentID;
    
}
