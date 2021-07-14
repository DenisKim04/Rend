package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CarRepository;
import kg.Cab.Rend.mapper.CarMapper;
import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDto saveCar(CarDto car) {
        Car car2 = CarMapper.INSTANCE.car(car);
        Car car1 = carRepository.save(car2);
        return CarMapper.INSTANCE.carDto(car1);


    }

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> allName(String name) {
        List<Car> cars = carRepository.findByName(name);
        return CarMapper.INSTANCE.listCatDto(cars);
    }


    @Override
    public List<CarDto> allYears(Short year) {
        List<Car> cars = carRepository.findByYear(year);
        return CarMapper.INSTANCE.listCatDto(cars);
    }


    @Override
    public List<CarDto> allSeats(Byte seats) {
        List<Car> cars = carRepository.findBySeats(seats);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> allBaggage(Byte baggage) {
        List<Car> cars = carRepository.findByBaggage(baggage);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> allDoor(Byte doors) {
        List<Car> cars = carRepository.findByDoors(doors);
        return CarMapper.INSTANCE.listCatDto(cars);
    }


    @Override
    public List<CarDto> findByRendPrice(RendPrice rendPrice) {
        List<Car> cars = carRepository.findByRendPrice(rendPrice);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> findByCarDescription(CarDescription carDescription) {
        List<Car> cars = carRepository.findByCarDescription(carDescription);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> findByCategoryCar(CategoryCar categoryCar) {
        List<Car> cars = carRepository.findByCategoryCar(categoryCar);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> findByPrice(BigDecimal price) {
        List<Car> cars = carRepository.findByPrice(price);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> findByYears(Short year) {
        List<Car> cars = carRepository.findByYears(year);
        return CarMapper.INSTANCE.listCatDto(cars);
    }
}
