package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.model.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    //->
    Car car(CarDto carDto);
    List<Car> listCar(List<CarDto> carDto);
    //<-
    CarDto carDto(Car car);
    List<CarDto> listCatDto(List<Car> car);
}
