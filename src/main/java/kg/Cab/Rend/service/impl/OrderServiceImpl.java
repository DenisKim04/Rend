package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.*;
import kg.Cab.Rend.mapper.OrderMapper;
import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.LocationRendDto;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.model.object.GetFromFront;
import kg.Cab.Rend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;
    @Autowired
    private RendPriceService rendPriceService;
    @Autowired
    private LocationRendService locationRendService;


//    public UserDto GetFromFrontToUser (GetFromFront getFromFront){
//        UserDto user = new UserDto();
//        user.setName(getFromFront.getName());
//        user.setLastName(getFromFront.getLastName());
//        user.setEmail(getFromFront.getEmail());
//        user.setPhoneNumber(getFromFront.getPhoneNumber());
//        return user;
//    }
//          UserDto userDto = GetFromFrontToUser(getFromFront);
//          User userCreate = UserMapper.INSTANCE.toUser(userDto);
//      System.out.println(userCreate);

    @Override
    public OrderDto saveOrder(GetFromFront getFromFront) {
        CarDto car = carService.findById(getFromFront.getCarId());
        LocationRendDto locationRendGet = locationRendService.findByID(getFromFront.getPleaseGet().getId());
        LocationRendDto locationRendSet = locationRendService.findByID(getFromFront.getPleaseSet().getId());
        UserDto userDto = new UserDto();
        userDto.setName(getFromFront.getName());
        userDto.setLastName(getFromFront.getLastName());
        userDto.setPhoneNumber(getFromFront.getPhoneNumber());
        userDto.setEmail(getFromFront.getEmail());
        UserDto user1 = userService.finUserByEmail(getFromFront.getEmail());
        if (user1 == null) {
            userDto = userService.saveUser(userDto);
            OrderDto orderDto = new OrderDto();
            return orderDto = saveOrders(car, userDto, getFromFront, locationRendGet, locationRendSet);
        } else {
            OrderDto orderDto = new OrderDto();
            return orderDto = saveOrders(car, user1, getFromFront, locationRendGet, locationRendSet);
        }
    }


    private OrderDto saveOrders(CarDto car, UserDto user, GetFromFront getFromFront,
                                LocationRendDto locationRendGet, LocationRendDto locationRendSet) {
        OrderDto orderDto = new OrderDto();


        try {
            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

            //Setting dates
            orderDto.setStartDateRent(new Date());
            orderDto.setEndDateRent(getFromFront.getEndDate());

            String CurrentDate = dates.format(orderDto.getStartDateRent().getTime());
            String FinalDate = dates.format(orderDto.getEndDateRent().getTime());

            Date date1 = dates.parse(CurrentDate);
            Date date2 = dates.parse(FinalDate);

            //Comparing dates
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            orderDto.setTotalSum(car.getRendPrice().getPrice() * differenceDates);
            System.out.println(differenceDates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderDto.setCar(car);
        orderDto.setUser(user);
        orderDto.setStartDateRent(getFromFront.getStartDate());
        orderDto.setEndDateRent(getFromFront.getEndDate());
        orderDto.setPleaseGet(locationRendGet);
        orderDto.setPleaseSet(locationRendSet);
        Order DtoToOrder = OrderMapper.INSTANCE.toOrder(orderDto);
        Order orderSave = orderRepository.save(DtoToOrder);
        return OrderMapper.INSTANCE.orderToDto(orderSave);
    }

    @Override
    public List<OrderDto> find() {

        List<Order> orderList = orderRepository.findAll();
        return OrderMapper.INSTANCE.orderListToDto(orderList);

    }
}


/*
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        RendPrice rendPrice = order.getCar().getRendPrice();
        rendPrice = rendPriceRepository.findById(priceId).orElse(null);
        if (rendPrice.getId() == null) {
            System.out.println("Not found");
        }
        Car car = order.getCar();
        car = carRepository.findById(carId).orElse(null);
        if (car.getId() == null) {
            System.out.println("Not found");
        }
        User user = order.getUser();
        user = userRepository.finUserByEmail(email);
                if (user == null) {

          UserDto user2 = orderDto.getUser();
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
*/
