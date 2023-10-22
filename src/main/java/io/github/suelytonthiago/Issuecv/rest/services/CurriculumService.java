package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.repositories.CurriculumRepository;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.CustomException;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.ObjectNotFoundException;
import io.github.suelytonthiago.Issuecv.rest.dto.CurriculumRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository curriculumRepository;
    @Autowired
    private ProfessionalExperienceService experienceService;
    @Autowired
    private AcademicEducationService educationService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    public Curriculum findById(Long id){
        return curriculumRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("The curriculum with id: %s is not found or not exist",id)
                ));
    }

    @Transactional
    public Curriculum findByUser(HttpServletRequest request){
        var user = userService.findById(jwtService.getClaimId(request));
        return curriculumRepository.findByUser(user)
                .orElseThrow(() ->new ObjectNotFoundException("The curriculum is not found or not exist"));
    }

    @Transactional
    public Curriculum createNewCV(HttpServletRequest request,CurriculumRequestDto curriculumDto){
        var experiences = experienceService.saveAll(curriculumDto.getExperiences());
        var educations = educationService.saveAll(curriculumDto.getEducations());
        var user = userService.findById(jwtService.getClaimId(request));
        var curriculum = Curriculum.of(curriculumDto,user,experiences,educations);
        return curriculumRepository.save(curriculum);
    }

    @Transactional
    public void deleteCVById(Long id){
        try{
            var curriculum = findById(id);
            curriculumRepository.delete(curriculum);
        }
        catch(DataIntegrityViolationException e){
            throw new CustomException(String.format("The CV with id: %s cannot be deleted",id));
        }
    }


}
