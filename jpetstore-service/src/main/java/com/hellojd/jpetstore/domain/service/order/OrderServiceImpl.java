/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.hellojd.jpetstore.domain.service.order;

import com.hellojd.jpetstore.domain.model.Item;
import com.hellojd.jpetstore.domain.model.LineItem;
import com.hellojd.jpetstore.domain.model.Order;
import com.hellojd.jpetstore.domain.model.Sequence;
import com.hellojd.jpetstore.domain.repository.item.ItemRepository;
import com.hellojd.jpetstore.domain.repository.item.LineItemRepository;
import com.hellojd.jpetstore.domain.repository.order.OrderRepository;
import com.hellojd.jpetstore.domain.repository.sequence.SequenceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eduardo Macarron
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private ItemRepository itemRepository;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private SequenceRepository sequenceRepository;

    @Inject
    private LineItemRepository lineItemRepository;

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.order.OrderService#insertOrder(com.hellojd.jpetstore.domain.model.Order)
     */
    @Override
    @Transactional
    public int insertOrder(Order order) {
        order.setOrderId(getNextId("ordernum"));
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = new Integer(lineItem.getQuantity());
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("itemId", itemId);
            param.put("increment", increment);
            itemRepository.updateInventoryQuantity(param);
        }

        orderRepository.insertOrder(order);
        orderRepository.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemRepository.insertLineItem(lineItem);
        }
        return order.getOrderId();
    }

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.order.OrderService#getOrder(int)
     */
    @Override
    @Transactional
    public Order getOrder(int orderId) {
        Order order = orderRepository.getOrder(orderId);
        order.setLineItems(lineItemRepository.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            Item item = itemRepository.getItem(lineItem.getItemId());
            item.setQuantity(itemRepository.getInventoryQuantity(lineItem
                    .getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.order.OrderService#getOrdersByUsername(java.lang.String)
     */
    @Override
    public List<Order> getOrdersByUsername(String username) {
        return orderRepository.getOrdersByUsername(username);
    }

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.order.OrderService#getNextId(java.lang.String)
     */
    @Override
    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = (Sequence) sequenceRepository.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next "
                    + name + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceRepository.updateSequence(parameterObject);
        return sequence.getNextId();
    }

}