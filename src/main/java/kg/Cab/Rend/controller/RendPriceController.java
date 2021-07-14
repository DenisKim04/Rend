package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RendPriceController {
    @Autowired
    private RendPriceService rendPriceService;

    @PostMapping("/api/v1/savePrice")
    public RendPriceDto save(@RequestBody RendPriceDto rendPriceDto){
        return rendPriceService.saveRendPrice(rendPriceDto);
    }
    @GetMapping("/api/vi/sort")
    public List<RendPriceDto> sort(){
        return rendPriceService.sorted();
    }
    @PutMapping("api/v1/update")
    public RendPriceDto update(@RequestBody RendPriceDto rendPriceDto){
        return rendPriceService.updatePrice(rendPriceDto);
    }

}
