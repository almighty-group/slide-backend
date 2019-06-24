package com.group.almighty.slidebackend.Services;

import com.group.almighty.slidebackend.Configurations.AppConfig;
import com.group.almighty.slidebackend.Dao.*;
import com.group.almighty.slidebackend.Dto.CreateUserDTO;
import com.group.almighty.slidebackend.Model.Activation;
import com.group.almighty.slidebackend.Model.Rider;
import com.group.almighty.slidebackend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private ActivationDao activationDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private MemberIdGenerator memberIdGenerator;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RiderGroupDao riderGroupDao;

    @Autowired
    private RiderDao riderDao;

    public String createUser(CreateUserDTO createUserDTO){
        Activation activation = activationDao.findByPhoneNumberAndActivationCode(createUserDTO.getPhoneNumber(), createUserDTO.getActivationCode());
        if(activation == null){
            return "Phone number does not exist in the database. Please re-start sign up process.";
        }

        if(activation.isActivated() != true){
            return "Activate phone number and try again.";
        }

        if(createUserDTO.getPassword() != createUserDTO.getConfirmPassword()){
            return "Passwords don't match";
        }

        User user = new User();

        user.setEmail(createUserDTO.getEmail());
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setPhoneNumber(String.valueOf(createUserDTO.getPhoneNumber()));
        user.setMemberId(memberIdGenerator.generateMemberId(createUserDTO));
        user.setPassword(appConfig.passwordEncoder().encode(createUserDTO.getPassword()));
        long i = new Long(createUserDTO.getRoleId());
        user.setRole(roleDao.findById(i));
        user.setStatus("NEW");
        user.setUsername(user.getPhoneNumber());
        user.setEnabled(true);
        userDao.save(user);

        user = userDao.findByPhoneNumber(user.getPhoneNumber());
        if(createUserDTO.getRoleId() == 3) {
            //set rider entity
            Rider rider = new Rider();
            rider.setRiderGroup(riderGroupDao.findById(1L));
            rider.setUser(user);
            riderDao.save(rider);
        }

        return "success";

    }
}

