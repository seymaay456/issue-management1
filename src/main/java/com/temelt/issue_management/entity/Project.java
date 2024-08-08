package com.temelt.issue_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Project extends BaseEntity{
    //her issue bir project tablosuna nesnesine bağlanacak.
    @Id //bu classın bir entity olmasını sağlayan min gereksim bir ıd.
    @GeneratedValue(strategy = GenerationType.AUTO) //ıd kolonun otogenerated olmasını sağlamak için.
    private Long id;

    @Column(name = "projectCode",unique = true)
    private String projectCode;

    @Column(name = "projectName",length = 400)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;

    //her projenin bir user managerı olsun.

}
