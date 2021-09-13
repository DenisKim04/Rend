package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;
import kg.Cab.Rend.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {Swagger2Config.CATEGORY_CAR})
@RestController
@RequestMapping("/api/v1/category_car")
@CrossOrigin
public class CategoryCarController {
    @Autowired
    private CategoryCarService categoryCarService;

    @PostMapping("/saveCategoryCar")
    public CategoryCarDto saveCategoryCar(@RequestBody CategoryCarDto categoryCar) {
        return categoryCarService.saveCategoryCar(categoryCar);
    }

    @GetMapping("/findCategoryCar")
    public List<CategoryCarDto> findCategoryCar(@RequestBody List<CategoryCarDto> categoryCarDto) {
        return categoryCarService.findCategoryCar();
    }
}
