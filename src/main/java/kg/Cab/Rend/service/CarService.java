package kg.Cab.Rend.service;

import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.dto.CarDto;

import java.util.List;


public interface CarService {
    public CarDto saveCar(CarDto car);

    public List<CarDto> findAll();

    CarDto findById(Long id);

    public List<CarDto> allName(String name);


    public List<CarDto> allYears(Short year);

    public List<CarDto> allSeats(Byte seats);

    public List<CarDto> allBaggage(Byte baggage);

    public List<CarDto> allDoor(Byte doors);

    List<CarDto> findByRendPrice(RendPrice rendPrice);

    List<CarDto> findByCarDescription(CarDescription carDescription);

    List<CarDto> findByCategoryCar(CategoryCar categoryCar);

    List<CarDto> findByPrice(double price);

    List<CarDto> findByYears(Short year);

    CarDto update(CarDto carDto, Long id);

}
