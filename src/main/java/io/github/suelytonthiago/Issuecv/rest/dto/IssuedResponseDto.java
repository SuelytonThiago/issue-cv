package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.entites.Issued;
import io.github.suelytonthiago.Issuecv.domain.enums.IssueStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class IssuedResponseDto {

    private IssueStatus status;
    private LocalDate requestData;
    private LocalDate issuedData;
    private CurriculumResponseDto curriculum;

    public static IssuedResponseDto of (Issued issued){
        return IssuedResponseDto.builder()
                .status(issued.getStatus())
                .requestData(issued.getRequestData())
                .issuedData(issued.getIssuedData())
                .curriculum(CurriculumResponseDto.of(issued.getCurriculum()))
                .build();
    }
}
