package io.github.suelytonthiago.Issuecv.domain.entites;

import io.github.suelytonthiago.Issuecv.rest.dto.CurriculumRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String professionalGoal;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany
    @JoinColumn(name = "experience_id")
    private List<ProfessionalExperience> experiences = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "education_id")
    private List<AcademicEducation> educations = new ArrayList<>();

    public static Curriculum of(CurriculumRequestDto request,
                                Users users,
                                List<ProfessionalExperience> experiences,
                                List<AcademicEducation> educations){
        return Curriculum.builder()
                .professionalGoal(request.getProfessionalGoal())
                .user(users)
                .experiences(experiences)
                .educations(educations)
                .build();
    }


}
