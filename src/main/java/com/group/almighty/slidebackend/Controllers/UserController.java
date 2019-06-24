package com.group.almighty.slidebackend.Controllers;

import com.group.almighty.slidebackend.Dto.CreateUserDTO;
import com.group.almighty.slidebackend.Dto.ResponseDTO;
import com.group.almighty.slidebackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v3/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public @ResponseBody ResponseDTO createUser(@RequestBody CreateUserDTO createUserDTO){
        if(!createUserDTO.getPassword().equals(createUserDTO.getConfirmPassword())){
            return new ResponseDTO("XX", "Passwords don't match", null);
        }

        String result = userService.createUser(createUserDTO);

        if(result.equalsIgnoreCase("success")){
            return new ResponseDTO("00", "Registration successful. Please log in and book rides.", null);
        }else{
            return new ResponseDTO("XX", result, null);
        }
    }

}
