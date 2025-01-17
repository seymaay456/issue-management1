package com.temelt.issue_management.dto;

import com.temelt.issue_management.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee; //sadece dışarıyla iletişim kuran classlar oluşturuyorum.
    private ProjectDto project;
}
