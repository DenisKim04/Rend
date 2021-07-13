package kg.Cab.Rend.controller;

import kg.Cab.Rend.dao.Repository.OrderRepository;
import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public OrderDto saveOrder(OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @GetMapping("/findOrder")
    public List<OrderDto> find() {
        return orderService.find();
    }

}
