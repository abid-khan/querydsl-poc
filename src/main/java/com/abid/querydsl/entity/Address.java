package com.abid.querydsl.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by abidkhan on 25/01/17.
 */
@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address extends  AbstractAuditablEntity {

    private String city;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User  user;


}
