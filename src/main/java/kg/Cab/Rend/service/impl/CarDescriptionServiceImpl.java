package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.CarDescriptionRepository;
import kg.Cab.Rend.mapper.CarDescriptionMapper;
import kg.Cab.Rend.model.CarDescription;
import kg.Cab.Rend.model.dto.CarDescriptionDto;
import kg.Cab.Rend.service.CarDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDescriptionServiceImpl implements CarDescriptionService {
    @Autowired
   private CarDescriptionRepository carDescriptionRepository;


    @Override
    public CarDescriptionDto saveCarDescription(CarDescriptionDto carDescription) {
        CarDescription carDescription1 = CarDescriptionMapper.INSTANCE.carDescriptionTo(carDescription);
        CarDescription carDescription2 = carDescriptionRepository.save(carDescription1);

        return CarDescriptionMapper.INSTANCE.carDescriptionToDto(carDescription2);
    }

    @Override
    public List<CarDescriptionDto> findAll() {
        List<CarDescription> carDescriptions = carDescriptionRepository.findAll();
        return CarDescriptionMapper.INSTANCE.listCarDescriptionToDto(carDescriptions);
    }
}
