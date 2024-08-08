package com.temelt.issue_management.repo;

import com.temelt.issue_management.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//dataJpa'nin bize sunduğu şey repositoryler.
// Bu entityler bir interface aracılığıyla database kaydedilip, okunup,sorgulanması vb. Bunlar için jpa repository oluşturuyorum.

public interface IssueRepository extends JpaRepository<Issue,Long> {
    Page<Issue> findAll(Pageable pageable);

    //<> olarak yazdığım şey bu repository hangi tabloya hizmet edecek, id nedir?
    //hiç kod yazmadan tablolarda birçok işlevi gerçekleştirebiliyoruz.

}
