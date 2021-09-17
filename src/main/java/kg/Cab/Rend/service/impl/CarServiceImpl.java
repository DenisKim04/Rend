package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CarRepository;
import kg.Cab.Rend.mapper.CarMapper;
import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.dto.CarDescriptionDto;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.dto.CategoryCarDto;
import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.model.object.StatusCar;
import kg.Cab.Rend.service.CarDescriptionService;
import kg.Cab.Rend.service.CarService;
import kg.Cab.Rend.service.CategoryCarService;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarDescriptionService carDescriptionService;
    @Autowired
    private CategoryCarService categoryCarService;
    @Autowired
    private RendPriceService rendPriceService;

    @Override
    public CarDto saveCar(CarDto carDto) {
        CategoryCarDto categoryCarDto = categoryCarService.findById(carDto.getCategoryCar().getId());
        carDto.setCategoryCar(categoryCarDto);
        CarDescriptionDto carDescriptionDto = carDescriptionService.saveCarDescription(carDto.getCarDescription());
        carDto.setCarDescription(carDescriptionDto);
        RendPriceDto rendPriceDto = rendPriceService.saveRendPrice(carDto.getRendPrice());
        carDto.setRendPrice(rendPriceDto);
        Car car2 = CarMapper.INSTANCE.car(carDto);
        Car car1 = carRepository.save(car2);
        return CarMapper.INSTANCE.carDto(car1);


    }

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public CarDto findByNumCar(String numCar) {
        Car car = carRepository.findByNumCar(numCar);
        return CarMapper.INSTANCE.carDto(car);
    }

    @Override
    public CarDto findById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        if(car == null){
            throw new RuntimeException("Not found");

        }
        return CarMapper.INSTANCE.carDto(car);
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
    public List<CarDto> findByPrice(double price) {
        List<Car> cars = carRepository.findByPrice(price);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public List<CarDto> findByYears(Short year) {
        List<Car> cars = carRepository.findByYears(year);
        return CarMapper.INSTANCE.listCatDto(cars);
    }

    @Override
    public CarDto update(CarDto carDto, Long id) {
        Car car = CarMapper.INSTANCE.car(carDto);
        if (carRepository.existsById(id)) {
            Car car1 = carRepository.findById(id).get();
            car1.setName(car.getName());
            car1.setYear(car.getYear());
            car1.setStatusCar(car.getStatusCar());
            car1.setSeats(car.getSeats());
            car1.setBaggage(car.getBaggage());
            car1.setDoors(car.getDoors());
            car1.setPicketer(car.getPicketer());
            car1 = carRepository.update(car.getName(), car.getYear(), car.getStatusCar(),
                    car.getSeats(), car.getBaggage(), car.getDoors(), car.getPicketer());
            return CarMapper.INSTANCE.carDto(car1);
        }else {
            System.out.println("Id is not found");
        }
        return null;
    }

    @Override
    public CarDto updateActive(StatusCar statusCar, boolean active, Long id) {
        if(carRepository.existsById(id)){
            Car car = carRepository.findById(id).get();
            car.setStatusCar(statusCar);
            car.setActive(active);
            car = carRepository.save(car);
            return CarMapper.INSTANCE.carDto(car);
        }else {
            System.out.println("Id is not fund");
        }
        return null;
    }

    @Override
    public List<CarDto> sortByCategory() {
        List<Car> carList = carRepository.findAllByCategory();
        return CarMapper.INSTANCE.listCatDto(carList);
    }
}