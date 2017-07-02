package com.hellojd.jpetstore.domain.service.order;

import com.hellojd.jpetstore.domain.model.Order;

import java.util.List;

public interface OrderService {

    int insertOrder(Order order);

    Order getOrder(int orderId);

    List<Order> getOrdersByUsername(String username);

    int getNextId(String name);

}