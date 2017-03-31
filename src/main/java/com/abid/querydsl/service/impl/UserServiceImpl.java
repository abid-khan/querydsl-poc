package com.abid.querydsl.service.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abid.querydsl.entity.QOrder;
import com.abid.querydsl.entity.QUser;
import com.abid.querydsl.entity.User;
import com.abid.querydsl.repository.UserRepository;
import com.abid.querydsl.service.base.UserService;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * Created by abidkhan on 25/01/17.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        QUser user =QUser.user;
        BooleanExpression booleanExpression =  user.id.eq(id);
        JPQLQuery<User> query = new JPAQuery<User>(entityManager);
        List<User>  users =  ( List<User> ) query.from(user).select(Projections.fields(User.class,user.email)).fetch();
        return userRepository.findOne(booleanExpression);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findOrders(Long id) {
        QUser user =QUser.user;
        QOrder order =QOrder.order;

        JPQLQuery<User> query = new JPAQuery<User>(entityManager);
        List<User> updatedUser=  query.from(user).innerJoin(user.orders,order ).groupBy(user.id).fetchAll().fetch();
        return  updatedUser;
    }
}
