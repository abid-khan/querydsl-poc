package com.abid.querydsl.service.base;

import com.abid.querydsl.entity.Order;

/**
 * Created by abidkhan on 25/01/17.
 */
public interface OrderService {

    /**
     *
     * @param order
     * @return
     */
    Order save(Order order);
}
