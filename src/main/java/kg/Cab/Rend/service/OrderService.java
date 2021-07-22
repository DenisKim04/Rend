package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.object.GetFromFront;

import java.util.List;

public interface OrderService {
    public OrderDto saveOrder(GetFromFront getFromFront);

    OrderDto returnOrder(OrderDto orderDto,Long id );
    List<OrderDto> find ();


}
