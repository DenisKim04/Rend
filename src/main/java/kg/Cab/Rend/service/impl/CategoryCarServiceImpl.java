package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCarServiceImpl implements CategoryCarService{
    @Autowired
    CategoryCarService categoryCarService;


    @Override
    public CategoryCar saveCategoryCar(CategoryCar car) {
        return null;
    }
}
