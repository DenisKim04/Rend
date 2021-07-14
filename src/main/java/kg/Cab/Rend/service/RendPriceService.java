package kg.Cab.Rend.service;

import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.dto.RendPriceDto;

import java.util.List;

public interface RendPriceService {

    RendPriceDto saveRendPrice(RendPriceDto rendPriceDto);

    List<RendPriceDto> sorted();

    RendPriceDto updatePrice(RendPriceDto rendPriceDto);
}
