package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.*;
import kg.Cab.Rend.mapper.CarMapper;
import kg.Cab.Rend.mapper.OrderMapper;
import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.model.Order;
import kg.Cab.Rend.model.object.StatusCar;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.LocationRendDto;
import kg.Cab.Rend.model.dto.OrderDto;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.model.object.GetFromFront;
import kg.Cab.Rend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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



    private UserDto GetFromFrontToUser(GetFromFront getFromFront) {
        UserDto user = new UserDto();
        user.setName(getFromFront.getName());
        user.setLastName(getFromFront.getLastName());
        user.setEmail(getFromFront.getEmail());
        user.setPhoneNumber(getFromFront.getPhoneNumber());

        return user;
    }


    @Override
    public OrderDto examinationOrder(GetFromFront getFromFront) {           // проверка на наличие был ли рание зарегистрован ползователь
        CarDto car = carService.findById(getFromFront.getCarId());
        OrderDto orderDtoSaver = new OrderDto();
        if (car.isActive() != false) {
            car = carService.updateActive(StatusCar.RENTED, false, car.getId());
        } else {
            System.out.println("These car is rented");
        }
        UserDto userDto = GetFromFrontToUser(getFromFront);
        UserDto finderUser = userService.finUserByEmail(getFromFront.getEmail());
        if (finderUser == null) {                      // в случии если пользователя нет то полльзователь сохраняется в базе данных
            userDto = userService.saveUser(userDto);  // для того чтолбы занать кто заказал машину
            return orderDtoSaver = saverOrders(car, userDto, getFromFront);
        } else {

            return orderDtoSaver = saverOrders(car, userDto, getFromFront);
        }

    }

    private double sumDate(Date startDate, Date endDate) {
        try {
            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
            String CurrentDate = dates.format(startDate.getTime());
            String FinalDate = dates.format(endDate.getTime());
            Date date1 = dates.parse(CurrentDate);
            Date date2 = dates.parse(FinalDate);
            long difference = Math.abs(date1.getTime() - date2.getTime());
            double differenceDates = difference / (24 * 60 * 60 * 1000);
            return differenceDates;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private OrderDto saverOrders(CarDto car, UserDto user, GetFromFront getFromFront) {
        OrderDto orderDto = new OrderDto();
        LocationRendDto locationRendGet = locationRendService.findById(getFromFront.getPleaseGet().getId());
        LocationRendDto locationRendSet = locationRendService.findById(getFromFront.getPleaseSet().getId());
        orderDto.setTotalSum((car.getRendPrice().getPrice() * sumDate(getFromFront.getStartDate(),getFromFront.getEndDate())));
        orderDto.setTotalSum(orderDto.getTotalSum()-discounts(sumDate(getFromFront.getStartDate(),getFromFront.getEndDate()),orderDto.getTotalSum()));
        // подчет оплаты
        orderDto.getUser().getWalletUser().setMoney(orderDto.getUser().getWalletUser().getMoney()-orderDto.getTotalSum());// вычит денег из кошелька
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
    private double discounts(double sumOfDay, double totalSum){         // расчет скидки в зависмости до суммы дней
        double sales;
        if (sumOfDay > 7){
            sales = 5;
            return salePrice(sales,totalSum);

        }else if(sumOfDay > 10){
            sales = 10;
            return salePrice(sales,totalSum);

        }else if (sumOfDay > 13){
            sales = 20;
            return salePrice(sales,totalSum);
        }else {
         return totalSum;
        }
    }
    private  double salePrice(double percentSales,double totalSum){
        double totalSumPostSales = totalSum * percentSales/100;
        return totalSumPostSales;
    }

    @Override
    public OrderDto returnOrder(OrderDto orderDto, Long id) {
        if (orderRepository.existsById(id)) {
            Order order = orderRepository.findById(id).get();
            Date dateTimeToReturn = new Date();
            if (order.getEndDateRent().before(dateTimeToReturn)) {
                CarDto carDto = carService.updateActive(StatusCar.AVAILABLE, true, id);
                Car car = CarMapper.INSTANCE.car(carDto);
                order.setCar(car);
                Order orderSaver = orderRepository.save(order);
                return OrderMapper.INSTANCE.orderToDto(orderSaver);
            }
        }
        return null;
    }

    @Override
    public List<OrderDto> find() {
        List<Order> orderList = orderRepository.findAll();
        return OrderMapper.INSTANCE.orderListToDto(orderList);
    }

    @Override
    public List<OrderDto> choseCars(List<String> numCars) {


        return null;
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
