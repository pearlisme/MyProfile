package com.techyvillager.mymatrimony.repository;

import com.techyvillager.mymatrimony.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pearl
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {


}
