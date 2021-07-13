package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/rendPrice")
public class RendPriceController {
    @Autowired
    private RendPriceService rendPriceService;

    @PostMapping("/saveRendPrice")
    public RendPriceDto saveRendPrice(RendPriceDto rendPrice) {
        return rendPriceService.saveRendPrice(rendPrice);
    }

    @PutMapping("/updatePrice")
    public RendPriceDto update(BigDecimal price) {
        return rendPriceService.updatePrice(price);
    }
}
