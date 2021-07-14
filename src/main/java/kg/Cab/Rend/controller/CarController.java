package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/saveCar")
    public CarDto saveCar(@RequestBody CarDto car) {
        return carService.saveCar(car);
    }

    @GetMapping("/findAll")
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/findName")
    public List<CarDto> findByName(@RequestBody String car) {
        return carService.allName(car);
    }
    

    @GetMapping("/findYears")
    public List<CarDto> findYearsCar(@RequestBody Short year) {
        return carService.allYears(year);

    }

    @GetMapping("/findSeats")
    public List<CarDto> findSeatsInCar(@RequestBody Byte seats) {
        return carService.allSeats(seats);
    }

    @GetMapping("/findBaggage")
    public List<CarDto> findBaggage(@RequestBody Byte baggage) {
        return carService.allBaggage(baggage);
    }

    @GetMapping("/findDoors")
    public List<CarDto> findDoors(@RequestBody Byte doors) {
        return carService.allDoor(doors);
    }

    @GetMapping("/findByAllPrice")
    public List<CarDto> findByAllPrice(@RequestBody RendPrice rendPrice) {
        return carService.findByRendPrice(rendPrice);
    }

    @GetMapping("/findByAllCarDescription")
    public List<CarDto> findByAllCarDescription(@RequestBody CarDescription carDescription) {
        return carService.findByCarDescription(carDescription);
    }

    @GetMapping("/findCategoryCar")
    public List<CarDto> findByCategoryCar(@RequestBody CategoryCar categoryCar) {
        return carService.findByCategoryCar(categoryCar);
    }

    @GetMapping("/findByPrice")
    public List<CarDto> findPriceCar(@RequestBody BigDecimal price) {
        return carService.findByPrice(price);
    }

    @GetMapping("/findByYear")
    public List<CarDto> findYearCar(@RequestBody Short year) {
        return carService.findByYears(year);
    }

}














