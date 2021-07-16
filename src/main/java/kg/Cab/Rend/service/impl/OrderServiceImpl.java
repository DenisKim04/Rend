package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CarRepository;
import kg.Cab.Rend.dao.Repository.OrderRepository;
import kg.Cab.Rend.dao.Repository.RendPriceRepository;
import kg.Cab.Rend.dao.Repository.UserRepository;
import kg.Cab.Rend.mapper.OrderMapper;
import kg.Cab.Rend.mapper.UserMapper;
import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.service.OrderService;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RendPriceRepository rendPriceRepository;
    @Autowired
    UserService userService;

    @Override
    public OrderDto saveOrder(OrderDto orderDto, Long carId, Long priceId, Long userId) {
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        RendPrice rendPrice = order.getCar().getRendPrice();
        rendPrice = rendPriceRepository.findById(priceId).orElse(null);
        if (rendPrice.getId() == null){
            System.out.println("Not found");
        }
        Car car = order.getCar();
        car = carRepository.findById(carId).orElse(null);
        if (car.getId()== null){
            System.out.println("Not found");
        }
        User user = order.getUser();
               user = userRepository.findById(userId).orElse(null);
        if(user.getId() == null){
           UserDto user2 = UserMapper.INSTANCE.toUserDto(user);
           userService.saveUser(user2);
        }
        double summaOfRendDay = (order.getEndDateRent().getTime() - order.getStartDateRent().getTime()) / (1000 * 60 * 60 * 24);
        order.setTotalSum(rendPrice.getPrice() * (summaOfRendDay));
        order.setCar(car);
        order.setUser(user);
        order.getCar().setRendPrice(rendPrice);
        Order order1 = orderRepository.save(order);
        return OrderMapper.INSTANCE.orderToDto(order1);
    }


    @Override
    public List<OrderDto> find() {

        List<Order> orderList = orderRepository.findAll();
        return OrderMapper.INSTANCE.orderListToDto(orderList);

    }
}
