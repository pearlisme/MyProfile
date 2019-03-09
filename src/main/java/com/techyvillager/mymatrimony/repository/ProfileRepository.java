package com.techyvillager.mymatrimony.repository;

import com.techyvillager.mymatrimony.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {


}
