package com.group.almighty.slidebackend.Services;

import com.group.almighty.slidebackend.Dao.ActivationDao;
import com.group.almighty.slidebackend.Dao.UserDao;
import com.group.almighty.slidebackend.Dto.ActivationDTO;
import com.group.almighty.slidebackend.Model.Activation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ActivationService {

    @Autowired
    private ActivationDao activationDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SmsService smsService;

    public String sendActivation(String phoneNumber){
            Activation activation = activationDao.findByPhoneNumber(phoneNumber);
            if(activation!= null){
                activation.setActivated(false);
            }else{
                activation.setPhoneNumber(phoneNumber);
                activation.setActivationCode(generateActivationCode());
                activation.setActivated(false);
            }
            //send activation SMS
            String message = "Use " + activation.getActivationCode() + " to activate your phone number";
            smsService.sendSingle("SLIDE", phoneNumber, message, null);
            activationDao.save(activation);

            return "successful";
    }

    //generate 6 digit activation code for users to confirm phone number .
    private String generateActivationCode(){
        Random random = new Random();
        Integer val = random.nextInt(899999) + 100000;

        while(activationDao.findByActivationCode(String.valueOf(val)) != null){
            val = random.nextInt(899999) + 100000;
        }

        return String.valueOf(val);
    }

    public String activateUser(ActivationDTO activationDTO){
        Activation activation = activationDao.findByPhoneNumber(activationDTO.getPhoneNumber());

        if(activation == null){
            return "does not exist.";
        }

        if(activation.getActivationCode() != activationDTO.getActivationCode()){
            return "incorrect";
        }

        activation.setActivated(true);

        activationDao.save(activation);

        return "successful";
    }

}
