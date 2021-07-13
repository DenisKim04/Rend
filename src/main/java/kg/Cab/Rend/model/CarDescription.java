package kg.Cab.Rend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "car_descriptions")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CarDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    private String typeOfDrive;
    private String side;
    private String fuel;
    private String transmission;
    private double fuelConsumption;
    private String lang;
}
