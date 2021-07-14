package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto saveUser(UserDto userDto);

    public List<UserDto> findUserByName(String userDto);

    public List<UserDto> findUserByLatsName(String lastName);

    public UserDto findUserByPhoneNumber(String phoneNumber);

    public UserDto finUserByEmail(String email);

    public UserDto upDataUser(UserDto userDto,Long id);
}

