package kg.Cab.Rend.service;

import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.model.object.StatusCar;

import java.util.List;


public interface CarService {
     CarDto saveCar(CarDto car);

     List<CarDto> findAll();

     CarDto findByNumCar(String numCar);

     CarDto findById(Long id);

     List<CarDto> allName(String name);


     List<CarDto> allYears(Short year);

     List<CarDto> allSeats(Byte seats);

     List<CarDto> allBaggage(Byte baggage);

     List<CarDto> allDoor(Byte doors);

    List<CarDto> findByRendPrice(RendPrice rendPrice);

    List<CarDto> findByCarDescription(CarDescription carDescription);

    List<CarDto> findByCategoryCar(CategoryCar categoryCar);

    List<CarDto> findByPrice(double price);

    List<CarDto> findByYears(Short year);

    CarDto update(CarDto carDto, Long id);

    CarDto updateActive(StatusCar statusCar, boolean active, Long id);

    List<CarDto> sortByCategory();

}
