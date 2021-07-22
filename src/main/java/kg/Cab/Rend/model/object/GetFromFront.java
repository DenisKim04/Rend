package kg.Cab.Rend.model.object;

import kg.Cab.Rend.model.LocationRend;
import lombok.Data;

import java.util.Date;
@Data
public class GetFromFront {
    private Long carId;
    //for order
    private LocationRend pleaseGet;
    private LocationRend pleaseSet;
    private Date startDate;
    private Date endDate;
    //for user
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

}
