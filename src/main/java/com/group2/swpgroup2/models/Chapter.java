package com.group2.swpgroup2.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapterID")
    public int chapterID;
    @ManyToOne
    @JoinColumn(name = "courseID")
    public Course course;
    @Column(name = "chapter_name")
    public String ChapterName;
    @Column(name = "chapter_num")
    public int ChapterNum;
    @Column(name = "chapter_description")
    public String ChapterDescription;

}
