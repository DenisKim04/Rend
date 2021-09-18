package kg.Cab.Rend.model.dto;

import lombok.Data;

@Data
public class CarDescriptionDto {
    private final Long id;
    private String typeOfDrive;
    private String side;
    private String fuel;
    private String transmission;
    private double fuelConsumption;
    private String lang;

}
