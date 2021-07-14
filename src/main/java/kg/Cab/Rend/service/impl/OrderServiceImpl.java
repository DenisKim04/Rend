package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.OrderRepository;
import kg.Cab.Rend.mapper.OrderMapper;
import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        long summaOfRendDay = orderDto.getEndDateRent().getTime() - orderDto.getStartDateRent().getTime();
        orderDto.setTotalSum(orderDto.getCar().getRendPrice().getPrice()*(double)(summaOfRendDay));
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        Order order1 = orderRepository.save(order);
            return OrderMapper.INSTANCE.orderToDto(order1);
    }

    @Override
    public List<OrderDto> find() {

        List<Order> orderList = orderRepository.findAll();
         return OrderMapper.INSTANCE.orderListToDto(orderList);

    }
}
