package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.UserRepository;
import kg.Cab.Rend.model.User;
import kg.Cab.Rend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
