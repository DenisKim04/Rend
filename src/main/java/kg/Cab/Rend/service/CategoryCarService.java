package kg.Cab.Rend.service;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;

import java.util.List;

public interface CategoryCarService {
    public CategoryCarDto saveCategoryCar(CategoryCar car);

    List<CategoryCarDto> findCategoryCar();
}
