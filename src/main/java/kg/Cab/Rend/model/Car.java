package kg.Cab.Rend.model;

import kg.Cab.Rend.model.object.StatusCar;
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
    private final Long id;
    private String name;
    private String numCar;
    private Short year;
    private StatusCar statusCar;
    private Byte seats;
    private Byte baggage;
    private Byte doors;
    private boolean active = true;
    private String picketer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private RendPrice rendPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carDescription_id")
    private CarDescription carDescription;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_car_id")
    private CategoryCar categoryCar;


}
