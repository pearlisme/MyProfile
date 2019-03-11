package com.techyvillager.mymatrimony.controller;

import com.techyvillager.mymatrimony.model.Profile;
import com.techyvillager.mymatrimony.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author pearl
 */
@RestController
@RequestMapping("/profiles")
class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){

        this.profileService = profileService;
    }

    /**
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllProfiles(){

        return profileService.getAllProfiles();
    }

    /**
     * @param profile
     * @return ResponseEntity
     */
    @PostMapping("/v1/add")
    public ResponseEntity addProfile(@RequestBody Profile profile){

         profileService.addProfile(profile);

        return profileService.getAllProfiles();
    }

    /**
     * @param id
     * @param profile
     * @return ResponseEntity
     */
    @PutMapping("/v1/update/{Id}")
    public ResponseEntity updateProfile(@PathVariable("Id") Long id, @RequestBody Profile profile){

        return profileService.updateProfile(id,profile);

    }

    /**
     * @param id
     * @return Profile
     */
    @PostMapping("/v1/search/{Id}")
    public Profile searchProfile(@PathVariable("Id") Long id){

        return profileService.searchProfile(id);
    }

    /**
     * @param id
     * @return ResponseEntity
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/v1/delete/{Id}")
    public ResponseEntity deleteProfile(@PathVariable("Id") Long id){

        return profileService.deleteProfile(id);

    }
}
