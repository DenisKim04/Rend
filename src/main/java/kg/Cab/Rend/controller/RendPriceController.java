package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = {Swagger2Config.REND_PRICE})
@RestController
@RequestMapping("api/v1/rendPrice")
@CrossOrigin
public class RendPriceController {
    @Autowired
    private RendPriceService rendPriceService;

    @PostMapping("/savePrice")
    public RendPriceDto save(@RequestBody RendPriceDto rendPriceDto){
        return rendPriceService.saveRendPrice(rendPriceDto);
    }
    @GetMapping("/sort")
    public List<RendPriceDto> sort(){
        return rendPriceService.sorted();
    }
    @PutMapping("/update")
    public RendPriceDto update(@RequestBody RendPriceDto rendPriceDto){
        return rendPriceService.updatePrice(rendPriceDto);
    }

}
