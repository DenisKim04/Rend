package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.service.CarDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarDescriptionController {
    @Autowired
    private CarDescriptionService carDescriptionService;
    @PostMapping("/saveCarDescription")
    public CarDescription saveCarDescription(@RequestBody CarDescription carDescription){
        return carDescriptionService.saveCarDescription(carDescription);
    }
}
