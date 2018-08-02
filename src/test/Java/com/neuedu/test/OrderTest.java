package com.neuedu.test;

import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testCreateOrder(){
        OrderService orderService=new OrderServiceImpl();
        orderService.createOrder();
    }


}
