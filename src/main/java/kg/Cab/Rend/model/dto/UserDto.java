package kg.Cab.Rend.model.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String activeCode;
}
