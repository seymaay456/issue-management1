package com.temelt.issue_management.service.impl;

import com.temelt.issue_management.dto.IssueDto;
import com.temelt.issue_management.repo.IssueRepository;
import com.temelt.issue_management.service.IssueService;
import com.temelt.issue_management.util.TPage;
import com.temelt.issue_management.entity.Issue;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

//Bir interfaceın implementasyonunu yaptığım için onun tüm methodlarını override etmem gerekiyor.

public class IssueServiceImplementation implements IssueService {

    /*save methodu, issueServiceImplemantation save işlemini bu entitynin repositorysi üzerinden gerçekleştiriyor.
    bu sebeple onun repositorysine inject etmem lazım:

    @Autowired*/

    private final ModelMapper modelMapper;

    private final IssueRepository issueRepository;
    //final bir nesneye atama yapmayı sadece constructorda yapabilirsin.

    public IssueServiceImplementation (ModelMapper modelMapper, IssueRepository issueRepository){
        this.modelMapper = modelMapper;
        this.issueRepository = issueRepository;
    }

    @Override
    public IssueDto save(IssueDto issue) {

        if (issue.getDate() ==null){
            throw  new IllegalArgumentException("Issue Date cannot be null");
        }
        Issue issueDb = modelMapper.map(issue, Issue.class);

       issueDb =  issueRepository.save(issueDb);
       return modelMapper.map(issueDb,IssueDto.class);
//servisten sonraki hiçbi katmanda dtolarla konuşmayacağız. servis ve servisten dışarı doğru çıkarken.

    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page =new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }

}
