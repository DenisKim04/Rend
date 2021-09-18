package kg.Cab.Rend.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RendPriceDto {
    private final Long id;
    private double price;
    private Date startDate;
    private Date endDate;
}
