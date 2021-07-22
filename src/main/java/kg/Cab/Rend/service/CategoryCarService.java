package kg.Cab.Rend.service;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;

import java.util.List;

public interface CategoryCarService {
    CategoryCarDto findById(Long id);

    public CategoryCarDto saveCategoryCar(CategoryCar car);

    List<CategoryCarDto> findCategoryCar();
}
