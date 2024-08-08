package com.temelt.issue_management.repo;

import com.temelt.issue_management.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {


  List<Project> getByProjectCode(String projectCode);
    //ben projectCodeunu vereyim ona karşılık gelen proje gelsin.


  List<Project> getByProjectCodeAndProjectNameContains(String projectCode, String name);
    //adı AndProjectNameContains gönderdiğim queryi içerecek ve proje kodu da parametre.

  //List<Project> getAllByProjectCodeAndIdNotNull(String projectCode);
    //     ID null olmayacak ve proje kodu da şu olan kayıtlar gelsin.


    @Override
    Page<Project> findAll(Pageable pageable);
    //tablolarda kayıtları çekerken sayfalama yapabiliyoruz.
    //Pagination (sayfalama), büyük veri kümelerini küçük parçalara bölerek sayfalarda gösterme işlemidir.
    // Bu, performans iyileştirmesi sağlar ve kullanıcı deneyimini geliştirir, çünkü tüm veri kümesinin bir kerede yüklenmesi yerine, yalnızca gerekli olan kısım yüklenir.
    //Pagination büyük veri kümelerini küçük parçalara böler.
    //Pageable arayüzü, sayfa numarası, sayfa boyutu ve sıralama bilgilerini içerir.
    //Page arayüzü, sayfa içeriğini ve sayfalama meta verilerini içerir.

    @Override
    List<Project> findAll(Sort sort);
}
