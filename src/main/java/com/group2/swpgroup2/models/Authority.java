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
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "authority")
    private String authority;
}
