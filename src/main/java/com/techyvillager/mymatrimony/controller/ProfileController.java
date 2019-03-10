package com.techyvillager.mymatrimony.controller;

import com.techyvillager.mymatrimony.model.Profile;
import com.techyvillager.mymatrimony.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){

        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity getAllProfiles(){

        return profileService.getAllProfiles();
    }

    @PostMapping("/v1/add")
    public ResponseEntity addProfile(@RequestBody Profile profile){

         profileService.addProfile(profile);

        return profileService.getAllProfiles();
    }

    @PutMapping("/v1/update/{Id}")
    public ResponseEntity updateProfile(@PathVariable("Id") Long id, @RequestBody Profile profile){

        return profileService.updateProfile(id,profile);

    }

    @PostMapping("/v1/search/{Id}")
    public Profile searchProfile(@PathVariable("Id") Long id){

        return profileService.searchProfile(id);
    }

    @DeleteMapping("/v1/delete/{Id}")
    public ResponseEntity deleteProfile(@PathVariable("Id") Long id){

        return profileService.deleteProfile(id);

    }
}
