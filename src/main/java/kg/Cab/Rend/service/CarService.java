package kg.Cab.Rend.service;

import kg.Cab.Rend.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {
public Car saveCar(Car car);
public  List<Car> allName(String name);
public List<Car> allActiveCars();
public List<Car> allYears(Short year);
public List<Car> allSeats(Byte seats);
public List<Car> allBaggage(Byte baggage);
public List<Car> allDoor(Byte doors);
public List<Car> allCars();
}
