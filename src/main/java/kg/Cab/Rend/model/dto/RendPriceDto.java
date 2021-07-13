package kg.Cab.Rend.model.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class RendPriceDto {
    private  Long id;
    private BigDecimal price;
    private Data startDate;
    private Data endDate;
}
