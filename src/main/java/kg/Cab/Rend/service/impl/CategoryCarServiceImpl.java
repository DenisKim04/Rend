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
    public CategoryCarDto findById(Long id) {
        CategoryCar categoryCar = categoryCarRepository.getById(id);
        return CategoryCarMapper.INSTANCE.categoryCarDto(categoryCar);
    }

    @Override
    public CategoryCarDto saveCategoryCar(CategoryCarDto categoryCar) {
        CategoryCar categoryCars = CategoryCarMapper.INSTANCE.categoryCarDto(categoryCar);
          CategoryCar carSaver = categoryCarRepository.save(categoryCars);

        return CategoryCarMapper.INSTANCE.categoryCarDto(carSaver);
    }

    @Override
    public List<CategoryCarDto> findCategoryCar() {
        List<CategoryCar> categoryCars = categoryCarRepository.findAll();
        return CategoryCarMapper.INSTANCE.listCategoryCarDto(categoryCars);
    }



    @Override
    public CategoryCarDto findByCategoryName(String categoryName) {
        CategoryCar categoryCarFinder = categoryCarRepository.findCategoryName(categoryName);
        return CategoryCarMapper.INSTANCE.categoryCarDto(categoryCarFinder);
    }
}
