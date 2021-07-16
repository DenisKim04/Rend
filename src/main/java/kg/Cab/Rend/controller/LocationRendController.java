package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.LocationRend;
import kg.Cab.Rend.model.dto.LocationRendDto;
import kg.Cab.Rend.service.LocationRendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = {Swagger2Config.LOCATION_REND})
@RestController
@RequestMapping("/api/v1/LocationRend")
@CrossOrigin
public class LocationRendController {
    @Autowired
    private LocationRendService locationRendService;

    @PostMapping("/saveLocationRend")
    public LocationRendDto save(@RequestBody LocationRendDto locationRendDto) {
        return locationRendService.save(locationRendDto);
    }

    @GetMapping("/findLocationRend")
    public List<LocationRendDto> find() {
        return locationRendService.find();
    }


}
