package com.group2.swpgroup2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "managerID")
    private int Id;
    @Column(name = "username")
    private String UserName;
    @Column(name = "name")
    private String Name;
    @Column(name = "org_name")
    private String OrgName;
    @Column(name = "img_src")
    private String ImgSrc;
    @Column(name = "rating")
    private float Rating;

}
