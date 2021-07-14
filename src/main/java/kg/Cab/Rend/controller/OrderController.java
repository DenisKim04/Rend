package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @GetMapping("/findOrder")
    public List<OrderDto> find() {
        return orderService.find();
    }

}
