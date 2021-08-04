package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto saveUser(UserDto userDto);

    List<UserDto> findAll();

    public List<UserDto> findUserByName(String userDto);

    public List<UserDto> findUserByLatsName(String lastName);

    public UserDto findUserByPhoneNumber(String phoneNumber);

    public UserDto finUserByEmail(String email);
    public UserDto upDataUser(UserDto userDto, Long id);
    public UserDto upDataUserByName(String name, Long id);
    public UserDto upDataUserLastName(String lastname, Long id);
    public UserDto upDataUserByPhone(String phone, Long id);
    public UserDto upDataUserByEmail(String email, Long id);

}

