package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDto saveUser(UserDto user) {
        return userService.saveUser(user);
    }

    @GetMapping("/findUserByName")
    public List<UserDto> findUserByName(String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/findUserByLastName")
    public List<UserDto> findUserByLastName(String lastName) {
        return userService.findUserByLatsName(lastName);
    }

    @GetMapping("/findUserByPhoneNumber")
    public UserDto findUserByPhoneNumber(String phone) {
        return userService.findUserByPhoneNumber(phone);
    }

    @GetMapping("/findUserByEmail")
    public UserDto findUserByEmail(String email) {
        return userService.finUserByEmail(email);
    }

    @PutMapping("/upDataUser")
    public UserDto upDataUser(@RequestBody UserDto userDto, Long id) {
        return userService.upDataUser(userDto, id);
    }
}

