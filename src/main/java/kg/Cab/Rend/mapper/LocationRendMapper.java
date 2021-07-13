package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.LocationRend;
import kg.Cab.Rend.model.dto.LocationRendDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LocationRendMapper {
    LocationRendMapper INSTANCE = Mappers.getMapper(LocationRendMapper.class);

    //->
    LocationRend toLocationRend(LocationRendDto dto);

    List<LocationRend> toListLocationRend();

    //<-
    LocationRendDto locationRendToDto(LocationRend locationRend);

    List<LocationRendDto> listLocationRendToDto(List<LocationRend> locationRend);
}
