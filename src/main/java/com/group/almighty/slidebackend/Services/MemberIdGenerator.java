package com.group.almighty.slidebackend.Services;

import com.group.almighty.slidebackend.Dao.RiderDao;
import com.group.almighty.slidebackend.Dao.UserDao;
import com.group.almighty.slidebackend.Dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;

@Service
public class MemberIdGenerator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RiderDao riderDao;

    public String generateMemberId(CreateUserDTO createUserDTO){

        try {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String truncYear = String.valueOf(year).substring(2,4);
            String truncFirstName = "";
            if(createUserDTO.getFirstName().length() <=3){
                truncFirstName = createUserDTO.getFirstName();
            }else{
                truncFirstName = createUserDTO.getFirstName().substring(0, 3);
            }

            String memberId = "";
            switch (createUserDTO.getRoleId()) {
                case 1:

                case 2:

                case 3: memberId = "SL/RIDER/"+ truncFirstName + "/" + truncYear.concat(String.valueOf(riderDao.numberOfSignedUpRidersThisMonth()));

                case 4:
            }
            return memberId;
        }catch(Exception exception){
            return "error";
        }
    }
}
