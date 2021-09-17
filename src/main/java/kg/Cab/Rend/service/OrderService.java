package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.object.GetFromFront;

import java.util.List;

public interface OrderService {
    public OrderDto examinationOrder(GetFromFront getFromFront);

    OrderDto returnOrder(OrderDto orderDto,Long id );

    List<OrderDto> find ();

    List<OrderDto> choseCars(List<String> numCar);

}
