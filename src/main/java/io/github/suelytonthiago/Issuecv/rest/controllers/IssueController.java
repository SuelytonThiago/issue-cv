package io.github.suelytonthiago.Issuecv.rest.controllers;

import io.github.suelytonthiago.Issuecv.domain.entites.Issue;
import io.github.suelytonthiago.Issuecv.rest.dto.CurriculumRequestDto;
import io.github.suelytonthiago.Issuecv.rest.dto.IssueResponseDto;
import io.github.suelytonthiago.Issuecv.rest.dto.IssuedResponseDto;
import io.github.suelytonthiago.Issuecv.rest.services.IssueService;
import io.github.suelytonthiago.Issuecv.rest.services.IssuedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issue")
@SecurityRequirement(name = "bearerAuth")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/add")
    @Operation(summary = "This endpoint is responsible for scheduling the generation of a CV")
    public ResponseEntity<Void> addNewCVToIssue(HttpServletRequest request,
                                                @RequestBody @Valid CurriculumRequestDto curriculumDto){
        issueService.addNewCVToIssue(request,curriculumDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status")
    @Operation(summary = "This endpoint is responsible for checking whether the CV has already been generated and is awaiting user confirmation")
    public ResponseEntity<IssueResponseDto> getIssueStatus(HttpServletRequest request){
        var response = IssueResponseDto.of(issueService.getIssueStatus(request));
        return ResponseEntity.ok(response);
    }


    @PostMapping("/confirm")
    @Operation(summary = "Eset endpoint is responsible for confirming the generated CV data")
    public ResponseEntity<IssuedResponseDto> confirmIssuedCV(HttpServletRequest request){
        return ResponseEntity.ok(issueService.confirmIssuedCV(request));
    }

}
