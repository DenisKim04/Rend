package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.LocationRendRepository;
import kg.Cab.Rend.mapper.LocationRendMapper;
import kg.Cab.Rend.model.LocationRend;
import kg.Cab.Rend.model.dto.LocationRendDto;
import kg.Cab.Rend.service.LocationRendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationRendServiceImpl implements LocationRendService {
    @Autowired
    LocationRendRepository locationRendRepository;



    @Override
    public LocationRendDto save(LocationRendDto locationRendDto) {
        LocationRend locationRend = LocationRendMapper.INSTANCE.toLocationRend(locationRendDto);
        LocationRend locationRend1 = locationRendRepository.save(locationRend);
        return LocationRendMapper.INSTANCE.locationRendToDto(locationRend1);
    }

    @Override
    public List<LocationRendDto> find() {
        List<LocationRend> locationRend = locationRendRepository.findAll();

        return LocationRendMapper.INSTANCE.listLocationRendToDto(locationRend);
    }

    @Override
    public LocationRendDto findById(Long id) {
        LocationRend locationRend = locationRendRepository.findById(id).get();
        return LocationRendMapper.INSTANCE.locationRendToDto(locationRend);
    }

    @Override
    public LocationRendDto updateStreetName(String streetName, Long id) {
        if (locationRendRepository.existsById(id)) {
            LocationRend locationRend1 = locationRendRepository.findById(id).get();
            locationRend1.setStreet(streetName);
            LocationRend locationRend2 = locationRendRepository.save(locationRend1);
            return LocationRendMapper.INSTANCE.locationRendToDto(locationRend2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }

    @Override
    public LocationRendDto updateHoseNum(int hoseNum, Long id) {

        if (locationRendRepository.existsById(id)) {
            LocationRend locationRend1 = locationRendRepository.findById(id).get();
            locationRend1.setNumNous(hoseNum);
            LocationRend locationRend2 = locationRendRepository.save(locationRend1);
            return LocationRendMapper.INSTANCE.locationRendToDto(locationRend2);
        } else {
            System.out.println("Id is not found");
        }
        return null;
    }


}
