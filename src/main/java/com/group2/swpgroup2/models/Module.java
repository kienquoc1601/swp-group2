package com.group2.swpgroup2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduleID")
    public int moduleID;
    @ManyToOne
    @JoinColumn(name = "chapterID")
    public Chapter chapter;
    @Column(name = "module_name")
    public String ModuleName;
    @Column(name = "module_num")
    public int ModuleNum;
    @Column(name = "module_type")
    public int ModuleType;//1-text , 2-video , 3-quiz
}
