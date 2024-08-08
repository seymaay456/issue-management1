package com.temelt.issue_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "issue_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode


public class IssueHistory extends BaseEntity{
    @Id //bu classın bir entity olmasını sağlayan min gereksim bir ıd.
    @GeneratedValue(strategy = GenerationType.AUTO) //ıd kolonun otogenerated olmasını sağlamak için.
    private Long id;
    private Issue issue;

    @JoinColumn(name = "issue_id")
    @ManyToOne (optional = true,fetch = FetchType.LAZY)
    private Issue ıssue;

    @Column(name = "description",length = 400)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne (optional = true,fetch = FetchType.LAZY)
    private User assignee;

}
