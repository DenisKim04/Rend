package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.dto.CategoryCarDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryCarMapper {
    CategoryCarMapper INSTANCE  = Mappers.getMapper(CategoryCarMapper.class);
    //->
    CategoryCarDto categoryCarDto(CategoryCar categoryCar);

    List<CategoryCarDto> listCategoryCarDto(List<CategoryCar> categoryCars);
    //<-
    CategoryCar categoryCarDto(CategoryCarDto categoryCarDto);

}
