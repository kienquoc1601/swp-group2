package com.group2.swpgroup2.models;
import java.sql.Date;

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
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionID")
    public Integer questionID;
    @Column(name = "studentID")
    public Integer studentID;
    @Column(name = "courseID")
    public Integer courseID;
    @Column(name = "isSolve")
    public Boolean isSolved;
    @Column(name = "q_name")
    public String qName;
    @Column(name = "q_content")
    public String qContent;
    @Column(name = "date")
    public Date Date;

}
