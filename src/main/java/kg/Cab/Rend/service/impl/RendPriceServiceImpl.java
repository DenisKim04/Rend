package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.RendPriceRepository;
import kg.Cab.Rend.mapper.RendPriceMapper;
import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RendPriceServiceImpl implements RendPriceService {
    @Autowired
    private RendPriceRepository rendPriceRepository;

    @Override
    public RendPriceDto saveRendPrice(RendPriceDto rendPrice) {
        RendPrice rendPrice1 = RendPriceMapper.INSTANCE.toRendPrice(rendPrice);
        RendPrice rendPrice2 = rendPriceRepository.save(rendPrice1);
        return RendPriceMapper.INSTANCE.rendPriceToDto(rendPrice2);
    }

    @Override
    public List<RendPrice> sorted() {
        List<RendPrice>
                rentPriceList = rendPriceRepository.findAll();
        List<RendPrice> rentPrices = rentPriceList
                .stream().sorted(Comparator.comparing(RendPrice::getPrice))
                .collect(Collectors.toList());
         return RendPriceMapper.INSTANCE.listToRendPrice(rentPrices);
    }

    @Override
    public RendPriceDto updatePrice(BigDecimal price) {
        RendPrice rendPrice = new RendPrice();
        rendPrice.setPrice(price);
        RendPrice rendPrice2 = rendPriceRepository.updatePrice(rendPrice.getPrice());
        return RendPriceMapper.INSTANCE.rendPriceToDto(rendPrice2);
    }


}
