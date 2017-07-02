package com.hellojd.jpetstore.app.order;

import javax.inject.Inject;

import com.hellojd.jpetstore.domain.model.Account;
import com.hellojd.jpetstore.domain.model.Cart;
import com.hellojd.jpetstore.domain.model.Order;
import com.hellojd.jpetstore.domain.model.UserDetails;
import com.hellojd.jpetstore.domain.service.order.OrderService;

import org.dozer.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class OrderHelper {
    @Inject
    protected OrderService orderService;

    @Inject
    protected Mapper beanMapper;

    public Order newOrder(OrderForm orderForm, Cart cart) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Account account = userDetails.getAccount();

        Order order = new Order();
        order.initOrder(account, cart);
        beanMapper.map(orderForm, order);
        orderService.insertOrder(order);
        return order;
    }
}
