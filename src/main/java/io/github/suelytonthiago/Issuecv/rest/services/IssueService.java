package io.github.suelytonthiago.Issuecv.rest.services;
import io.github.suelytonthiago.Issuecv.domain.entites.Issue;
import io.github.suelytonthiago.Issuecv.domain.enums.IssueStatus;
import io.github.suelytonthiago.Issuecv.domain.repositories.IssueRepository;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.CustomException;
import io.github.suelytonthiago.Issuecv.rest.dto.CurriculumRequestDto;
import io.github.suelytonthiago.Issuecv.rest.dto.IssuedResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private IssuedService issuedService;


    @Transactional
    public void addNewCVToIssue(HttpServletRequest request, CurriculumRequestDto curriculumDto){
        var curriculum = curriculumService.createNewCV(request,curriculumDto);
        var issue = Issue.builder()
                .status(IssueStatus.PENDING)
                .requestData(LocalDate.now())
                .curriculum(curriculum)
                .build();
        issueRepository.save(issue);
    }

    public List<Issue> findAllIssue(){
        return issueRepository.findAll();
    }

    public Issue findById(Long id){
        return issueRepository.findById(id).orElse(null);
    }

    @Transactional
    public Issue getIssueStatus(HttpServletRequest request){
        var curriculum = curriculumService.findByUser(request);
        return issueRepository.findByCurriculum(curriculum)
                .orElseThrow(() -> new CustomException(
                        "The CV was not found or has not yet been requested to be issued"
                ));
    }

    public void setStatusCVToWaitingConfirmation(){
        issueRepository.findTop3ByStatus(IssueStatus.PENDING).forEach(this::setStatus);
    }

    public void setStatus(Issue issue){
        issue.setStatus(IssueStatus.WAITING_CONFIRMATION);
        issueRepository.save(issue);
        System.out.println("serviço executado " + Instant.now());

    }

    @Transactional
    public IssuedResponseDto confirmIssuedCV(HttpServletRequest request){
        var issue = getIssueStatus(request);
        if(issue.getStatus() == IssueStatus.WAITING_CONFIRMATION){
            var issued = issuedService.addIssuedCV(issue);
            deleteIssue(issue);
            return IssuedResponseDto.of(issued);
        }
        throw new CustomException("The CV still needs to be processed to be issued");
    }

    public void deleteIssue(Issue issue){
        issueRepository.delete(issue);
    }
}
