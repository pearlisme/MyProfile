package com.techyvillager.mymatrimony.service;

import com.techyvillager.mymatrimony.model.Profile;
import com.techyvillager.mymatrimony.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {


    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
        initAction();
    }

    private void initAction() {
        Profile profile = new Profile(1,"system","9176767676","IND TX");
        addProfile(profile);
    }

    public ResponseEntity addProfile(Profile profile){
        profileRepository.save(profile);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
