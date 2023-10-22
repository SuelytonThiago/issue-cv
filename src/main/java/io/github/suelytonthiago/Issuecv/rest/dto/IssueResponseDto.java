package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.Issue;
import io.github.suelytonthiago.Issuecv.domain.entites.Issued;
import io.github.suelytonthiago.Issuecv.domain.enums.IssueStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class IssueResponseDto {

    private IssueStatus status;
    private LocalDate requestData;
    private CurriculumResponseDto curriculum;

    public static IssueResponseDto of (Issue issue){
        return IssueResponseDto.builder()
                .status(issue.getStatus())
                .requestData(issue.getRequestData())
                .curriculum(CurriculumResponseDto.of(issue.getCurriculum()))
                .build();
    }
}
