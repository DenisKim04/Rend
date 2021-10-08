package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.CarDescriptionDto;

import java.util.List;

public interface CarDescriptionService {
    public CarDescriptionDto saveCarDescription(CarDescriptionDto carDescription);

    List<CarDescriptionDto> findAll();

    CarDescriptionDto findById(Long id);

    CarDescriptionDto update(CarDescriptionDto carDescriptionDto,Long id);
}
