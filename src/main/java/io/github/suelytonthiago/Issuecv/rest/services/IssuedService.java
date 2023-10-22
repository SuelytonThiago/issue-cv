package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.Issue;
import io.github.suelytonthiago.Issuecv.domain.entites.Issued;
import io.github.suelytonthiago.Issuecv.domain.enums.IssueStatus;
import io.github.suelytonthiago.Issuecv.domain.repositories.IssuedRepository;
import io.github.suelytonthiago.Issuecv.rest.dto.IssuedResponseDto;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IssuedService {

    @Autowired
    private IssuedRepository issuedRepository;
    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private JwtService jwtService;

    public Issued addIssuedCV(Issue issue){
        var issued = Issued.builder()
                .status(IssueStatus.ISSUED)
                .requestData(issue.getRequestData())
                .issuedData(LocalDate.now())
                .curriculum(issue.getCurriculum())
                .build();
        return issuedRepository.save(issued);
    }

    public IssuedResponseDto getCurriculum(HttpServletRequest request){
        var curriculum = curriculumService.findByUser(request);
        return issuedRepository.findByCurriculum(curriculum).map(issued -> {
            return IssuedResponseDto.of(issued);
        }).orElseThrow(() -> new ObjectNotFoundException("The curriculum is not found or not issued"));
    }
}
