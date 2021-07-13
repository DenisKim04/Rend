package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.model.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    //->
    Order toOrder(OrderDto orderDto);

    List<Order> ListToOrder();

    //<-
    OrderDto orderToDto(Order order);

    List<OrderDto> orderListToDto(List<Order> orderList);

}
