package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.RendPriceRepository;
import kg.Cab.Rend.mapper.RendPriceMapper;
import kg.Cab.Rend.model.RendPrice;
import kg.Cab.Rend.model.dto.RendPriceDto;
import kg.Cab.Rend.service.RendPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
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
    public List<RendPriceDto> sorted(){
        List<RendPrice>
                rentPriceList = rendPriceRepository.findAll();
        List<RendPrice> rentPrices = rentPriceList
                .stream().sorted(Comparator.comparing(RendPrice::getPrice))
                .collect(Collectors.toList());
        return RendPriceMapper.INSTANCE.listRendPriceToDto(rentPrices);
    }

    @Override
    public RendPriceDto updatePrice(RendPriceDto rendPriceDto, Long id) {
        RendPrice rendPrice1 = RendPriceMapper.INSTANCE.toRendPrice(rendPriceDto);
        if(rendPriceRepository.existsById(id)){
        RendPrice rendPrice2 = rendPriceRepository.findById(id).get();
        rendPrice2.setStartDate(new Date());
        rendPrice2.setEndDate(new Date(rendPrice1.getStartDate().getTime()-1));
        if (rendPrice1.getPrice()==rendPrice2.getPrice()){
            rendPrice1.setStartDate(new Date());
            rendPrice1.setEndDate(new Date(rendPrice1.getStartDate().getTime() -1));
            RendPrice rendPriceNew = rendPriceRepository.save(rendPrice1);
            return RendPriceMapper.INSTANCE.rendPriceToDto(rendPriceNew);
        }
        RendPrice rendPrices =rendPriceRepository.save(rendPrice2);
        return RendPriceMapper.INSTANCE.rendPriceToDto(rendPrices);
        }
return null;
    }



}
