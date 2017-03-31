package com.abid.querydsl.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by abidkhan on 25/01/17.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends   AbstractAuditablEntity {

    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Order> orders;

}
