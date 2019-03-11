package com.techyvillager.mymatrimony.service;

import com.techyvillager.mymatrimony.model.CustomUserDetails;
import com.techyvillager.mymatrimony.model.User;
import com.techyvillager.mymatrimony.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author pearl
 */
@Service
public class CustomUserDetailSerivce implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username){

        Optional<User> usersOption = userRepository.findByUserName(username);

        usersOption
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return    usersOption.map(CustomUserDetails::new).get();
    }
}
