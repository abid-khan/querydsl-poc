package com.abid.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abid.querydsl.entity.Address;

/**
 * Created by abidkhan on 25/01/17.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
