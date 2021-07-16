package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = {Swagger2Config.ORDER})
@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public OrderDto saveOrder(@RequestBody OrderDto orderDto,@RequestParam Long carId,@RequestParam Long priceId,
                              @RequestParam Long userId) {
        return orderService.saveOrder(orderDto,carId ,priceId, userId);
    }

    @GetMapping("/findOrder")
    public List<OrderDto> find() {
        return orderService.find();
    }

}
