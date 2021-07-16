package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Short year;
    private StatusCar statusCar;
    private Byte seats;
    private Byte baggage;
    private Byte doors;
    private boolean active;
    private String picketer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private RendPrice rendPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carDescription_id")
    private CarDescription carDescription;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryCar_id")
    private CategoryCar categoryCar;


}
