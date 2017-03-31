package com.abid.querydsl.service.base;

import java.util.List;

import com.abid.querydsl.entity.User;

/**
 * Created by abidkhan on 25/01/17.
 */
public interface UserService {

    /**
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     *
     * @param id
     * @return
     */
    User findById(final Long id);

    /**
     *
     * @param user
     * @return
     */
    User save(User user);

    /**
     *
     * @param id
     * @return
     */
    List<User> findOrders(Long id);
}
