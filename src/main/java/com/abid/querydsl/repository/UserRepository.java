package com.abid.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.abid.querydsl.entity.User;

/**
 * Created by abidkhan on 25/01/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long >,QueryDslPredicateExecutor<User> {
}
