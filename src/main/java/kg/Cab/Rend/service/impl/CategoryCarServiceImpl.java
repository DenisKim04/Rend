package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CategoryCarRepository;
import kg.Cab.Rend.mapper.CategoryCarMapper;
import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;
import kg.Cab.Rend.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryCarServiceImpl implements CategoryCarService {
    @Autowired
    private CategoryCarRepository categoryCarRepository;


    @Override
    public CategoryCarDto saveCategoryCar(CategoryCar car) {
      CategoryCar car1 = categoryCarRepository.save(car);
        return CategoryCarMapper.INSTANCE.categoryCarDto(car1);
    }

    @Override
    public List<CategoryCarDto> findCategoryCar() {
        List<CategoryCar> categoryCars = categoryCarRepository.findAll();
        return CategoryCarMapper.INSTANCE.listCategoryCarDto(categoryCars);
    }
}
