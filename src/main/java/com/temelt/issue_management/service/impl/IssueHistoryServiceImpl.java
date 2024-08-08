package com.temelt.issue_management.service.impl;

import com.temelt.issue_management.repo.IssueHistoryRepository;
import com.temelt.issue_management.service.IssueHistoryService;
import com.temelt.issue_management.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private IssueHistoryRepository issueHistoryRepository;

    private IssueHistoryServiceImpl() {
    }

    public static IssueHistoryServiceImpl createIssueHistoryServiceImpl() {
        return new IssueHistoryServiceImpl();
    }


    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        //Business Logic
        if (issueHistory.getDate() ==null){
            throw new IllegalArgumentException("Issue cannot be null");
        }

        issueHistory = this.issueHistoryRepository.save(issueHistory);
        return issueHistory;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
