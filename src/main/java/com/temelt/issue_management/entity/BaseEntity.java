package com.temelt.issue_management.entity;

//bunun içine koyacağım bazı propertyler tüm tablolarımda yer almasını istiyorum.

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//nesnenin networkten taşınabilmesini veya diske yazılabilmesini

@Data //(bu bir anotation, bir interface, bu interface runtime ya da compile timeda bazı özellikler yetenekler kazandırabiliyoruz. )
@MappedSuperclass //(JPA'den gelen fieldların bütün tablolarda ortak olmasını sağlayan anatotion ekliyoruz. bunu koyduğumuz zaman diğer classlarda extend edilebilir hale geliyor.)


public abstract class BaseEntity implements Serializable {

//bu classın bazı özelliklerini overwrite etmek istersek diye abstract yaptık.


    //bu fieldların her bir özelliğini belirleme kısmı:
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    //name : bu property databasede hangi kolon üzerinde olsun.
    //length :  kaç karakterlik bi yere ayrılsın.
    //scale, precision : virgüllü sayılar için virgülden önceki sonraki hassasiyeti.
    //insertable : insert edilirken kayıt eklenebilsin mi içerisine.
    //nullable : null geçilsin mi bu kolon.
    //(bu anatoin ile bu kolonun veritabanı üzerindeki özelliklerini detaylandırıyoruz.
    private Date createdAt; //kayıt ne zaman eklendi.

    @Column(name = "created_by",length = 10)
    private String createdBy; //kim ekledi.

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt; //kayıt ne zaman güncellendi.

    @Column(name = "updated_by",length = 10)
    private String updatedBy; //kim güncelledi.

    @Column(name = "status")
    private Boolean status; //kayıdın durumu, false ise aktif değildir. true ise aktiftir.

    //yukarıdaki fieldların otomatikman getter ve setter methodları oluşmuş oluyor. Data anotation sayesinde. bu işi lombok sağlıyor.

}
