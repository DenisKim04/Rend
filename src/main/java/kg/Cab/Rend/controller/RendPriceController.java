package kg.Cab.Rend.controller;

import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RendPriceController {
    @Autowired
   private RendPriceService rendPriceService;
    @PostMapping
    public RendPrice saveRendPrice(RendPrice rendPrice){
        return rendPriceService.saveRendPrice(rendPrice);
    }
}
