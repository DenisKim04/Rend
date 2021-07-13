package kg.Cab.Rend.service;

import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.dto.RendPriceDto;

import java.math.BigDecimal;
import java.util.List;

public interface RendPriceService {
    public RendPriceDto saveRendPrice(RendPriceDto rendPrice);

    public List<RendPrice> sorted();

    public RendPriceDto updatePrice(BigDecimal price);
}
