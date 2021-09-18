package kg.Cab.Rend.model.dto;


import lombok.Data;
import java.util.Date;
import java.util.List;


@Data
public class OrderDto {
    private final Long id;
    private UserDto user;
    private CarDto car;
    private LocationRendDto pleaseGet;
    private LocationRendDto pleaseSet;
    private Date startDateRent;
    private Date endDateRent;
    private double totalSum;
    private boolean activeOrder;

}
