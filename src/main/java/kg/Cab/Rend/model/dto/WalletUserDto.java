package kg.Cab.Rend.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class WalletUserDto {
    private Long id;
    private Date startDate;
    private Date endDate;
    private double money;
}