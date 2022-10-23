package com.group2.swpgroup2.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
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
@Table(name = "Mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorID")
    private int Id;
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String Name;
    @Column(name = "fullname")
    private String FullName;
    @Column(name = "img_src")
    private String ImgSrc;
    @Column(name = "gender")
    private boolean Gender;
    @Column(name = "dob")
    private Date dob;
}
