package kg.Cab.Rend.model.dto;

import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.model.CategoryCar;
import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.StatusCar;
import lombok.Data;

@Data
public class CarDto {
    private Long id;
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
