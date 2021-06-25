package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CarRepository;
import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> allName(String name) {
        return carRepository.findByName(name);
    }

    @Override
    public List<Car> allActiveCars() {
        return carRepository.findByActive();
    }



    @Override
    public List<Car> allYears(Short year) {
        return carRepository.findByYear(year);
    }

    @Override
    public List<Car> allSeats(Byte seats) {
        return carRepository.findBySeats(seats);

    }

    @Override
    public List<Car> allBaggage(Byte baggage) {
        return carRepository.findByBaggage(baggage);
    }

    @Override
    public List<Car> allDoor(Byte doors) {
        return carRepository.findByDoors(doors);
    }

    @Override
    public List<Car> allCars() {
        return carRepository.findAll();
    }
}
