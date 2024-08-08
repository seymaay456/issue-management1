package com.temelt.issue_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity //(bu veritabanında bir tabloya karşılık gelecek.)
@Table (name = "issue")
@Data //getter ve setter methodları yaratmak için.
@NoArgsConstructor //baseEntity nesnesinin boş bir constructorını yaratıyor.
// Şey gibi public Issue(){
// }

@AllArgsConstructor //bu da tüm fieldlar için constructor oluşturan bir anotation.
//  public Issue(Long id, String description, Date date, IssueStatus issueStatus) {
//        this.id = id;
//        this.description = description;
//        this.date = date;
//        this.issueStatus = issueStatus;
//    }

@ToString
@EqualsAndHashCode

public class Issue extends BaseEntity{


    @Id //bu classın bir entity olmasını sağlayan min gereksim bir ıd.
    @GeneratedValue(strategy = GenerationType.AUTO) //ıd kolonun otogenerated olmasını sağlamak için.
    private Long id;

    @Column(name = "description",length = 400)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    //@Column(name = "status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY) //birçok issue classı bir tane usera bağlanabilir.
    //optinal true dersek, bu issue nesnesini bir usera bağlamasak da olur. null kalabilir.
    //fetch issue tablosuna select atılırken, user tablosuna bir join var, user tablosundaki ilişkili kaydını da join atılıp getirilsin mi? sorusuna karar veriyor.
    // Eager: bu data her zaman select edip getirilir.
    // Lazy: bu methodun getteri çağırıldığında yani ihtiyaç duyulduğunda getirilir.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;

}
