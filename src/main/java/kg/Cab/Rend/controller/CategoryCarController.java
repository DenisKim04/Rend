package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;
import kg.Cab.Rend.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoryCat")
public class CategoryCarController {
    @Autowired
    private CategoryCarService categoryCarService;

    @PostMapping("/saveCategoryCar")
    public CategoryCarDto saveCategoryCar(CategoryCar categoryCar) {
        return categoryCarService.saveCategoryCar(categoryCar);
    }

    @GetMapping("/findCategoryCar")
    public List<CategoryCarDto> findCategoryCar(List<CategoryCarDto> categoryCarDto) {
        return categoryCarService.findCategoryCar();
    }
}
