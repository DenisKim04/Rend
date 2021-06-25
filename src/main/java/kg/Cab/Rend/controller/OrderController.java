package kg.Cab.Rend.controller;

import kg.Cab.Rend.dao.Repository.OrderRepository;
import kg.Cab.Rend.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
       private OrderRepository orderRepository;
    @PostMapping("/saveOrder")
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
