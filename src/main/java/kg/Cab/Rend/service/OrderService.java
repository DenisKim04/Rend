package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    public OrderDto saveOrder(OrderDto order);

    List<OrderDto> find ();
}
