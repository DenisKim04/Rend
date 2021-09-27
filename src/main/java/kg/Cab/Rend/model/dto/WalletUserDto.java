package kg.Cab.Rend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WalletUserDto {
    private Long id;
    private Date startDate;
    private Date endDate;
    private double money;
}
