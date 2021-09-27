package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LocationRend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Street;
    private int numNous;

}
