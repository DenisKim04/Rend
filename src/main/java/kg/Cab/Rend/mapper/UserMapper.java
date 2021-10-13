package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Перевод в в Dto
    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> user);

    // Перевод обратно в User
    User toUser(UserDto userDto);

    List<User> toUserList(List<UserDto> user);


}
