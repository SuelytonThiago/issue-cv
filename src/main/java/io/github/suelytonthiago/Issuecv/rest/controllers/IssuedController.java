package io.github.suelytonthiago.Issuecv.rest.controllers;

import io.github.suelytonthiago.Issuecv.rest.dto.IssuedResponseDto;
import io.github.suelytonthiago.Issuecv.rest.services.IssuedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issued")
@SecurityRequirement(name = "bearerAuth")
public class IssuedController {

    @Autowired
    private IssuedService issuedService;

    @GetMapping("/cv")
    @Operation(summary = "This endpoint is used to retrieve the CV that has already been generated")
    public ResponseEntity<IssuedResponseDto> getCV(HttpServletRequest request){
        return ResponseEntity.ok(issuedService.getCurriculum(request));
    }
}
