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
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerID")
    public Integer answerID;
    @Column(name = "questionID")
    public Integer questionID;
    @Column(name = "mentorID")
    public Integer mentorID;
    @Column(name = "answer")
    public String answer;
    @Column(name = "date")
    public Date Date;
}
