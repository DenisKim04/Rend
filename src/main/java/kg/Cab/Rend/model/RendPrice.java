package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "rend_price")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RendPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private double price;
    private Date startDate;
    private Date endDate;

}
