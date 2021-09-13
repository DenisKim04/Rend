package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.model.dto.CarDescriptionDto;
import kg.Cab.Rend.service.CarDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {Swagger2Config.CAR_DESCRIPTION})
@RestController
@RequestMapping("/api/v1/car_description")
@CrossOrigin
public class CarDescriptionController {
    @Autowired
    private CarDescriptionService carDescriptionService;

    @PostMapping("/saveCarDescription")
    public CarDescriptionDto saveCarDescription(@RequestBody CarDescriptionDto carDescription) {
        return carDescriptionService.saveCarDescription(carDescription);
    }

    @GetMapping("/findCarDescription")
    public List<CarDescriptionDto> findCarDescription() {
        return carDescriptionService.findAll();
    }
}
