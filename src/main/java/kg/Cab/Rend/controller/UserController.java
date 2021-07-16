package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {Swagger2Config.USER})
@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findUserByName")
    public List<UserDto> findUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/findUserByLastName")
    public List<UserDto> findUserByLastName(@RequestParam String lastName) {
        return userService.findUserByLatsName(lastName);
    }

    @GetMapping("/findUserByPhoneNumber")
    public UserDto findUserByPhoneNumber(@RequestParam String phone) {
        return userService.findUserByPhoneNumber(phone);
    }

    @GetMapping("/findUserByEmail")
    public UserDto findUserByEmail(@RequestParam String email) {
        return userService.finUserByEmail(email);
    }

    @PutMapping("/upDataUser")
    public UserDto upDataUser(@RequestBody UserDto userDto, Long id) {
        return userService.upDataUser(userDto, id);
    }
}

