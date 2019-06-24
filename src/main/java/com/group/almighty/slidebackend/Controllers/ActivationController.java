package com.group.almighty.slidebackend.Controllers;

import com.group.almighty.slidebackend.Dao.UserDao;
import com.group.almighty.slidebackend.Dto.ActivationDTO;
import com.group.almighty.slidebackend.Dto.ResponseDTO;
import com.group.almighty.slidebackend.Services.ActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v3/activation")
public class ActivationController {

    @Autowired
    private ActivationService activationService;

    @Autowired
    private UserDao userDao;

    @GetMapping("/activate/{phoneNumber}")
    public @ResponseBody
    ResponseDTO getActivationCode(@PathVariable String phoneNumber ){
        if(phoneNumber == null || phoneNumber.isEmpty()){
            return new ResponseDTO("XX", "Phone number cannot be empty.", null);
        }

        if(userDao.findByPhoneNumber(phoneNumber) != null){
            return new ResponseDTO("01", "Phone number is already registered. Please, Log in. ", null);
        }

        try{
            long phone = Long.parseLong(phoneNumber.trim());
            String result = activationService.sendActivation(phoneNumber);
            if(result.equalsIgnoreCase("successful")){
                return new ResponseDTO("00", "Activation code sent successfully.", null);
            }else{
                return new ResponseDTO("XX", result, null);
            }

        }catch(Exception exc){
            exc.printStackTrace();
            return new ResponseDTO("XX", "Phone number must be an integer.", null);
        }
    }

    @PostMapping("/activate")
    public @ResponseBody ResponseDTO activateUser(@RequestBody ActivationDTO activationDTO){
        String result = activationService.activateUser(activationDTO);
        if(result.equalsIgnoreCase("successful")){
            return new ResponseDTO("00", "Activation Successful", null);
        } else if(result.equalsIgnoreCase("incorrect")){
            return new ResponseDTO("XX", "Incorrect activation code.. Please confirm the activation code.", null);
        }else{
            return new ResponseDTO("XX", "User details is not available for activation. Please sign up or log in if already registered.", null);
        }
    }
}
