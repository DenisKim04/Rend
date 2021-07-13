package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.dto.RendPriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RendPriceMapper {
    RendPriceMapper INSTANCE = Mappers.getMapper(RendPriceMapper.class);

    //->
    RendPrice toRendPrice(RendPriceDto rendPriceDto);

    List<RendPrice> listToRendPrice(List<RendPrice> rendPriceDto);

    //<-
    RendPriceDto rendPriceToDto(RendPrice rendPrice);

    List<RendPriceDto> listRendPriceToDto(List<RendPrice> rendPriceList);
}
