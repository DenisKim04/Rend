package kg.Cab.Rend.model.dto;

import kg.Cab.Rend.model.object.StatusCar;
import lombok.Data;

@Data
public class CarDto {
    private final Long id;
    private String name;
    private String numCar;
    private Short year;
    private StatusCar statusCar;
    private Byte seats;
    private Byte baggage;
    private Byte doors;
    private boolean active;
    private String picketer;
    private RendPriceDto rendPrice;
    private CarDescriptionDto carDescription;
    private CategoryCarDto categoryCar;
}
