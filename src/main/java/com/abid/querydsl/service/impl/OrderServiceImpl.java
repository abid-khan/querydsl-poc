package com.abid.querydsl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abid.querydsl.entity.Order;
import com.abid.querydsl.repository.OrderRepository;
import com.abid.querydsl.service.base.OrderService;

/**
 * Created by abidkhan on 25/01/17.
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public Order save(Order order) {
        return orderRepository.saveAndFlush(order);
    }
}
