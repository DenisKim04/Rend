package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.OrderRepository;
import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
