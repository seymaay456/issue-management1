package com.temelt.issue_management.service.impl;

import com.temelt.issue_management.repo.ProjectRepository;
import com.temelt.issue_management.service.ProjectService;
import com.temelt.issue_management.entity.Project;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    private ProjectServiceImpl() {
    }

    public static ProjectServiceImpl createProjectServiceImpl() {
        return new ProjectServiceImpl();
    }


    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null!");
        }
        return projectRepository.save(project);
    }


    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return List.of();
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {

        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
