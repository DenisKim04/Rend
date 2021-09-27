package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.model.dto.CarDescriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarDescriptionMapper {
    CarDescriptionMapper INSTANCE = Mappers.getMapper(CarDescriptionMapper.class);

    //->
    CarDescription carDescriptionTo(CarDescriptionDto carDescriptionDto);

    //<-
    CarDescriptionDto carDescriptionToDto(CarDescription carDescription);

    List<CarDescriptionDto> listCarDescriptionToDto(List<CarDescription> carDescriptions);

}
