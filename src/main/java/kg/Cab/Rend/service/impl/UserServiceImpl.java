package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.UserRepository;
import kg.Cab.Rend.mapper.UserMapper;
import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        User user1 = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDto(user1);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> user = userRepository.findAll();
        return UserMapper.INSTANCE.toUserDtoList(user);
    }


    @Override
    public List<UserDto> findUserByName(String name) {
        List<User> user = userRepository.findUserByName(name);
        return UserMapper.INSTANCE.toUserDtoList(user);
    }

    @Override
    public List<UserDto> findUserByLatsName(String lastName) {

        List<User> users1 = userRepository.findUserByLatsName(lastName);
        return UserMapper.INSTANCE.toUserDtoList(users1);
    }

    @Override
    public UserDto findUserByPhoneNumber(String phoneNumber) {

        User user1 = userRepository.findUserByPhoneNumber(phoneNumber);
        return UserMapper.INSTANCE.toUserDto(user1);
    }

    @Override
    public UserDto finUserByEmail(String email) {

        User user2 = userRepository.findUserByEmail(email);
        return UserMapper.INSTANCE.toUserDto(user2);
    }

    @Override
    public UserDto upDataUser(UserDto userDto, Long id) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        if (userRepository.existsById(id)) {
           User user1 = userRepository.findById(id).get();
            user1.setName(user.getName());
            user1.setEmail(user.getLastName());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setEmail(user.getEmail());
            user1 = userRepository.updateUser(user.getName(), user.getLastName(), user.getPhoneNumber(), user.getEmail());
            return UserMapper.INSTANCE.toUserDto(user1);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }
}
