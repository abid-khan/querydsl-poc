package com.abid.querydsl.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by abidkhan on 25/01/17.
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends  AbstractAuditablEntity {

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
