package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.LocationRendDto;

import java.util.List;

public interface LocationRendService {

    LocationRendDto save(LocationRendDto locationRendDto);
    List<LocationRendDto> find ();
}
