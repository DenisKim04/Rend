package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "rend_price")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RendPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private BigDecimal price;

}
