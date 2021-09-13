package kg.Cab.Rend.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
   // private WalletUsersDto walletUser;
}
