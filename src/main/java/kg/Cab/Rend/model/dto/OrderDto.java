package kg.Cab.Rend.model.dto;

import kg.Cab.Rend.model.Car;
import kg.Cab.Rend.model.LocationRend;
import kg.Cab.Rend.model.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {
    private Long id;
    private User user;
    private Car car;
    private LocationRend locationRend;
    private Date startDateRent;
    private Date endDateRent;
    private BigDecimal totalSum;
    private String comment;
}
