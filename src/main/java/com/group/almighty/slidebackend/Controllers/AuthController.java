package com.group.almighty.slidebackend.Controllers;

import com.group.almighty.slidebackend.Dto.LoginDTO;
import com.group.almighty.slidebackend.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v3/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping( value = "/login", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO){
        return authService.login(loginDTO.getPhoneNumber(), loginDTO.getPassword());
    }
}
