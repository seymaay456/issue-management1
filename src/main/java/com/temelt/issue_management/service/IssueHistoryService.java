package com.temelt.issue_management.service;

/*bussiness layer dediğimiz yer, bussiness logic.
Repositoryler üzerinden direkt veritabanına erişmicem.
Araya bir katman daha koyarak o katman üzerinde bir takım validationlar, adı boş olamaz, küçük harf içeremez gibi
kontrollerimin hepsini business logicte uygulamama özel olan mantıkta bunları burda tutuyoruz. */

import com.temelt.issue_management.entity.IssueHistory;
import org.springframework.data.domain.Pageable;


public interface IssueHistoryService {

    //method imzası taşıyacak : ne parametre alır ne geri döner.

    IssueHistory save (IssueHistory issueHistory); //bir method issue kaydını parametre aldı. o kaydettiği kaydın son hali geri döndü.
    IssueHistory getById (Long id); //getById için Id vericem bu methoda, bbu methodda bana bu idli kaydı vericek.

    org.springframework.data.domain.Page<IssueHistory>  getAllPageable(Pageable pageable);
    //pagination lı bir sorgu attığımız zaman page tipinde data döndürüyor.
    //Pagination (sayfalama), büyük veri kümelerini küçük parçalara bölerek sayfalarda gösterme işlemidir.
    // Bu, performans iyileştirmesi sağlar ve kullanıcı deneyimini geliştirir, çünkü tüm veri kümesinin bir kerede yüklenmesi yerine, yalnızca gerekli olan kısım yüklenir.
    //Pagination büyük veri kümelerini küçük parçalara böler.
    //Pageable arayüzü, sayfa numarası, sayfa boyutu ve sıralama bilgilerini içerir.
    //Page arayüzü, sayfa içeriğini ve sayfalama meta verilerini içerir.

    Boolean delete(IssueHistory issueHistory);
}
