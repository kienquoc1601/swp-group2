package com.group2.swpgroup2.models;
import java.util.Date;

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
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentID")
    private int studentID;
    // @OneToOne
    // @JoinColumn(name = "username")
    // private Account username;
    @Column(name = "username")
    private String username;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "img_src")
    private String img_src;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "dob")
    private Date dob;   
}
