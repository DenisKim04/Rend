package kg.Cab.Rend.model.dto;

import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.model.LocationRend;
import kg.Cab.Rend.model.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class OrderDto {
    private Long id;
    private UserDto user;
    private CarDto car;
    private LocationRendDto pleaseGet;
    private LocationRendDto pleaseSet;
    private Date startDateRent;
    private Date endDateRent;
    private double totalSum;

}
