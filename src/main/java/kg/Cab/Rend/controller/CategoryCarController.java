package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;
import kg.Cab.Rend.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoryCat")
public class CategoryCarController {
    @Autowired
    private CategoryCarService categoryCarService;

    @PostMapping("/saveCategoryCar")
    public CategoryCarDto saveCategoryCar(@RequestBody CategoryCar categoryCar) {
        return categoryCarService.saveCategoryCar(categoryCar);
    }

    @GetMapping("/findCategoryCar")
    public List<CategoryCarDto> findCategoryCar(@RequestBody List<CategoryCarDto> categoryCarDto) {
        return categoryCarService.findCategoryCar();
    }
}
