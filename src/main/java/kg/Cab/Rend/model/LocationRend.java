package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LocationRend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String AddressGet;
    private String AddressReturn;

}