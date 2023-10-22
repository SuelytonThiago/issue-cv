package io.github.suelytonthiago.Issuecv.rest.controllers;

import io.github.suelytonthiago.Issuecv.rest.dto.UserRequestDto;
import io.github.suelytonthiago.Issuecv.rest.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @Operation(summary = "This endpoint is used to create a new user")
    public ResponseEntity<Void> createNewUser(@RequestBody @Valid UserRequestDto request){
        userService.createNewUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    @Operation(summary = "This endpoint is used to update the user")
    public ResponseEntity<Void> updateUserData(HttpServletRequest request,
                                               @RequestBody @Valid UserRequestDto userDto){
        userService.updateUserData(request,userDto);
        return ResponseEntity.noContent().build();
    }

}
