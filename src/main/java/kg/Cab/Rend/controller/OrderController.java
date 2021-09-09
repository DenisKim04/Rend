package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.object.GetFromFront;
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
    public OrderDto saveOrder(@RequestBody GetFromFront getFromFront) {
        return orderService.examinationOrder(getFromFront);
    }

    @GetMapping("/findOrder")
    public List<OrderDto> find() {
        return orderService.find();
    }
    @PutMapping("/backCar")
    public OrderDto returnCar(OrderDto orderDto,Long id){
        return orderService.returnOrder(orderDto,id);
    }

}
