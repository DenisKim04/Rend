package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.User;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PatchMapping
    public User saveUser(User user){
        return userService.saveUser(user);
    }
}
