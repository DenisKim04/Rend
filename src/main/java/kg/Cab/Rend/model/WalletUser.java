package kg.Cab.Rend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "wallet_user")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WalletUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date startDate;
    private Date endDate;
    private double money;
}
