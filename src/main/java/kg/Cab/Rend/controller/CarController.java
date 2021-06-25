package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/saveCar")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
}
