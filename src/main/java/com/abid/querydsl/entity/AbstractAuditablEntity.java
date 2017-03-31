package com.abid.querydsl.entity;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Created by abidkhan on 25/01/17.
 */
@MappedSuperclass
public abstract class AbstractAuditablEntity extends AbstractPersistable<Long> {
}
