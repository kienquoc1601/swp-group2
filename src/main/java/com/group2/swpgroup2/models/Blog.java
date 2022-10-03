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
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private int blog_id;
    @Column(name = "title")
    private String title;
    @Column(name = "blog_image")
    private String blog_image;
    @Column(name = "blog_description")
    private String blog_description;
    @Column(name = "poster_uname")
    private String poster_uname;
    @Column(name = "blog_content")
    private String blog_content;
    @Column(name = "category")
    private String category;
    @Column(name = "rating")
    private float rating;
    @Column(name = "date")
    private Date date;
}
