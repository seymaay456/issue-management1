package com.temelt.issue_management.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100, unique = true)
    private String username;


    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_surname",length = 100)
    private String nameSurname;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY) //bir kullanıcıya birçok issue bağlanabilir
    private List<Issue> issues;
    //eğer bu kullanıcıyı select edersem bunun issuelarını görmek istersem

}
