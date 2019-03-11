package com.techyvillager.mymatrimony.repository;

import com.techyvillager.mymatrimony.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author pearl
 */
public interface UserRepository extends JpaRepository<User,Long> {

//    @Query("SELECT * from User where username =:username")
    Optional<User> findByUserName(String username);
}
