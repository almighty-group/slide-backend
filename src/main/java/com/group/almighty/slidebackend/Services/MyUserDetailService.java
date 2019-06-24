package com.group.almighty.slidebackend.Services;

import com.group.almighty.slidebackend.Dao.UserDao;
import com.group.almighty.slidebackend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    public MyUserDetailService(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByPhoneNumber(username);

        if (user == null){
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}

