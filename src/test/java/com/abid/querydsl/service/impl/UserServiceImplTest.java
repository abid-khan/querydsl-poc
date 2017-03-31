package com.abid.querydsl.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.abid.querydsl.entity.Address;
import com.abid.querydsl.entity.Order;
import com.abid.querydsl.entity.User;
import com.abid.querydsl.service.base.OrderService;
import com.abid.querydsl.service.base.UserService;

/**
 * Created by abidkhan on 25/01/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    public User createUser(){

        User  user  = new User();
        user.setEmail("abid.khan@appdirect.com");

        Address address1 = new Address();
        address1.setCity("Pune");
        address1.setUser(user);

        Address address2 = new Address();
        address2.setCity("Kolkata");
        address2.setUser(user);

        Set<Address> addressSet = new HashSet<Address>();
        addressSet.add(address1);
        addressSet.add(address2);

        user.setAddresses(addressSet);

        return  user;

    }


    public void createOrders(User user){
        Order order1= new Order();
        order1.setAmount(1.0);
        order1.setUser(user);
        orderService.save(order1);

        Order order2 = new Order();
        order2.setAmount(2.0);
        order2.setUser(user);
        orderService.save(order2);
    }


    @Ignore
    @Test
    @Rollback(true)
    public void save(){
        User user = createUser();
        user = userService.save(user);
        Assert.assertEquals(2,user.getAddresses().size());
    }


    @Test
    @Rollback(true)
    public void findById(){
        User user = createUser();
        user = userService.save(user);
        user = userService.findById(user.getId());
        Assert.assertEquals(2,user.getAddresses().size());
    }

    @Test
    @Rollback(true)
    public void findOrders(){
        User user = createUser();
        user = userService.save(user);
        createOrders(user);
        List<User> users = userService.findOrders(user.getId());
        Assert.assertEquals(2,user.getOrders().size());
    }
}
