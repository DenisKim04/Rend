package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.CategoryCarDto;

import java.util.List;

public interface CategoryCarService {
    CategoryCarDto findById(Long id);

    List<CategoryCarDto> findCategoryCar();


    CategoryCarDto findByCategoryName(String nameCategory);

    CategoryCarDto saveCategoryCar(CategoryCarDto categoryCarDto );


}

