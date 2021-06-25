package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CarDescriptionRepository;
import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.service.CarDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDescriptionServiceImpl implements CarDescriptionService {
    @Autowired
    CarDescriptionRepository carDescriptionRepository;
    @Override
    public CarDescription saveCarDescription(CarDescription carDescription) {
        return carDescriptionRepository.save(carDescription);
    }
}
