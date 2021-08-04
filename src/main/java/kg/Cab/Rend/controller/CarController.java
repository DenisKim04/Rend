package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {Swagger2Config.CAR})
@RestController
@RequestMapping("/api/v1/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;
    @PutMapping("/UpdateCar")
    public CarDto update(@RequestBody CarDto carDto,Long id){
        return carService.update(carDto,id);
    }

    @PutMapping("/updateActive")
    public  CarDto updateActive(@RequestParam StatusCar statusCar ,@RequestParam boolean active,@RequestParam Long id){
        return carService.updateActive(statusCar, active,id);
    }

    @PostMapping("/saveCar")
    public CarDto saveCar(@RequestBody CarDto car) {
        return carService.saveCar(car);
    }

    @GetMapping("/findAll")
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/findName")
    public List<CarDto> findByName(@RequestParam String car) {
        return carService.allName(car);
    }
    

    @GetMapping("/findYears")
    public List<CarDto> findYearsCar(@RequestParam Short year) {
        return carService.allYears(year);

    }

    @GetMapping("/findSeats")
    public List<CarDto> findSeatsInCar(@RequestParam Byte seats) {
        return carService.allSeats(seats);
    }

    @GetMapping("/findBaggage")
    public List<CarDto> findBaggage(@RequestParam Byte baggage) {
        return carService.allBaggage(baggage);
    }

    @GetMapping("/findDoors")
    public List<CarDto> findDoors(@RequestParam Byte doors) {
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
    public List<CarDto> findPriceCar(@RequestParam double price) {
        return carService.findByPrice(price);
    }

    @GetMapping("/findByYear")
    public List<CarDto> findYearCar(@RequestParam Short year) {
        return carService.findByYears(year);
    }

    @GetMapping("/sortByCategory")
        public List<CarDto> sortByCategory(){
        return carService.sortByCategory();
    }

    }

















