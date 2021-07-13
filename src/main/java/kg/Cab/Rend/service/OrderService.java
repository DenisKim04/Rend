package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.dto.UserDto;

import java.util.List;

public interface OrderService {
    public OrderDto saveOrder(OrderDto order);

    List<OrderDto> find ();
}
