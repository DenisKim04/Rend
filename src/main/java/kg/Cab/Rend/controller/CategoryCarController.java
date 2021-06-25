package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryCarController {
    @Autowired
       private CategoryCarService categoryCarService;
    @PostMapping("/saveCategoryCar")
    public CategoryCar saveCategoryCar(CategoryCar categoryCar){
        return categoryCarService.saveCategoryCar(categoryCar);
    }
}
