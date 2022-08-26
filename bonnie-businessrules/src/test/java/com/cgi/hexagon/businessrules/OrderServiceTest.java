package com.cgi.hexagon.businessrules;

import com.cgi.hexagon.businessrules.order.Order;
import com.cgi.hexagon.businessrules.order.IOrderService;
import com.cgi.hexagon.businessrules.order.OrderService;
import com.cgi.hexagon.businessrules.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    IOrderService orderLoader;

    OrderService orderService;

    UserService userService;

    ISender sender;

    @BeforeEach
    public void setup() {
        orderLoader = Mockito.mock(IOrderService.class);
        orderService = new OrderService(orderLoader, userService, sender);
    }

    @Test
    public void expectCallToALoaderWhenLoadIsCalled() {
        Order toBeLoaded = new Order()
                .withId(1L)
                .withGoodsId("awesome kit")
                .withStatus(Status.NEW);
        when(orderLoader.load(1L)).thenReturn(toBeLoaded);
        Order loadedOrder = orderService.loadOrder(1L);
        assertEquals(toBeLoaded, loadedOrder, "Loaded order should be the same one we provided to the mock. ");

    }
}