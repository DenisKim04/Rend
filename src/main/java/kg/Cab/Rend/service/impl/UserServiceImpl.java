package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.UserRepository;
import kg.Cab.Rend.dao.Repository.WalletUserRepository;
import kg.Cab.Rend.mapper.UserMapper;
import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.WalletUser;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletUserServiceImpl walletUserServiceImpl;

    @Override
    public UserDto saveUser(UserDto userDto) {
        String checkTruerEmail = userDto.getEmail().substring(-9,userDto.getEmail().length());
        if (checkTruerEmail.equals("@gmail.com")&& checkTruerEmail.equals("@mail.ru")){
        User user = UserMapper.INSTANCE.toUser(userDto);
        walletUserServiceImpl.saveWalletUser(userDto.getWalletUser());
        User user1 = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDto(user1);
        }else {
            System.out.println("email is not found");
            return null;
        }
    }
   //loop automation
    private UserDto LoopSaverUser (){
        for (int x = 0;x == 3;x++){

        }
        return null;
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
            User user2 = userRepository.save(user1);
            return UserMapper.INSTANCE.toUserDto(user2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }

    @Override
    public UserDto upDataUserByName(String name, Long id) {

        if (userRepository.existsById(id)) {
            User user1 = userRepository.findById(id).get();
            user1.setName(name);
            User user2 = userRepository.save(user1);
            return UserMapper.INSTANCE.toUserDto(user2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }

    @Override
    public UserDto upDataUserLastName(String lastname, Long id) {
        if (userRepository.existsById(id)) {
            User user1 = userRepository.findById(id).get();
            user1.setLastName(lastname);
            User user2 = userRepository.save(user1);
            return UserMapper.INSTANCE.toUserDto(user2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }

    @Override
    public UserDto upDataUserByPhone(String phone, Long id) {
        if (userRepository.existsById(id)) {
            User user1 = userRepository.findById(id).get();
            user1.setPhoneNumber(phone);
            User user2 = userRepository.save(user1);
            return UserMapper.INSTANCE.toUserDto(user2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }

    @Override
    public UserDto upDataUserByEmail(String email, Long id) {
        if (userRepository.existsById(id)) {
            User user1 = userRepository.findById(id).get();
            user1.setEmail(email);
            User user2 = userRepository.save(user1);
            return UserMapper.INSTANCE.toUserDto(user2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }

    }


