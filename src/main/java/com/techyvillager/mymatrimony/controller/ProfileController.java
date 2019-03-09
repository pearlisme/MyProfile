package com.techyvillager.mymatrimony.controller;

import com.techyvillager.mymatrimony.model.Profile;
import com.techyvillager.mymatrimony.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){

        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getAllProfiles(){

        return profileService.getAllProfiles();
    }

    @PostMapping("/v1/add")
    public ResponseEntity addProfile(@RequestBody Profile profile){


        return profileService.addProfile(profile);

    }

}
