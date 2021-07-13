package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.model.dto.CarDescriptionDto;
import kg.Cab.Rend.service.CarDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carDescription")
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
