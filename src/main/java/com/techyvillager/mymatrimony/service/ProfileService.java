package com.techyvillager.mymatrimony.service;

import com.techyvillager.mymatrimony.model.Profile;
import com.techyvillager.mymatrimony.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author pearl
 */
@Service
public class ProfileService {


    private final ProfileRepository profileRepository;

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
        return new ResponseEntity(profileRepository.save(profile), HttpStatus.ACCEPTED);
    }

    public ResponseEntity getAllProfiles() {
        return new ResponseEntity(profileRepository.findAll(),HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteProfile(@PathVariable Long id) {

        Profile profile = profileRepository.getOne(id);
        if (profile != null) {

            profileRepository.delete(profile);

            return new ResponseEntity("Deletion Successful",HttpStatus.ACCEPTED);

        }

        return new ResponseEntity("Deletion UnSuccessful",HttpStatus.NO_CONTENT);
    }

    public Profile searchProfile(Long id) {

        return profileRepository.findById(id).orElse(null);
    }

    public ResponseEntity updateProfile(Long id, Profile profile) {

        if(profileRepository.findById(id).isPresent()) {

            return new ResponseEntity(profileRepository.save(profile), HttpStatus.ACCEPTED);

        }
        return new ResponseEntity("No Profile Found",HttpStatus.NO_CONTENT);
    }
}
