package io.github.suelytonthiago.Issuecv.domain.entites;

import io.github.suelytonthiago.Issuecv.domain.enums.IssueStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Issued {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private IssueStatus status;
    private LocalDate requestData;
    private LocalDate issuedData;


    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
}
