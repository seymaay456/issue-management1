package com.temelt.issue_management.repo;

import com.temelt.issue_management.entity.IssueHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {


    Page<IssueHistory> findAll(Pageable pageable);
}
