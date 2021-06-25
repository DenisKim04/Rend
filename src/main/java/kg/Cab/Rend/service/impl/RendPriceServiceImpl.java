package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.RendPriceRepository;
import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendPriceServiceImpl implements RendPriceService {
    @Autowired
    RendPriceRepository rendPriceRepository;

    @Override
    public RendPrice saveRendPrice(RendPrice rendPrice) {
        return rendPriceRepository.save(rendPrice);
    }
}
