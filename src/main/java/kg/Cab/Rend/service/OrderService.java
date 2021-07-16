package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    public OrderDto saveOrder(OrderDto order,Long carId,Long priceId,Long userId);

    List<OrderDto> find ();
}
