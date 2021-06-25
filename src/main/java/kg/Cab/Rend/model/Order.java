package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;
    private String pickUpLocation;
    private String returnLocation;
    private Date startDateRent;
    private Date endDateRent;
    private BigDecimal totalSum;
    private String comment;

}
