package com.techyvillager.mymatrimony.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author pearl
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(User user) {
        this.id = user.getId();
        this.active = user.getActive();
        this.userName = user.getUserName();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer active;
    private String userName;
    private String name;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Role> roles;
}
