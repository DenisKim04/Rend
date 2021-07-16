package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.microservice.FileServiceFeting;
import kg.Cab.Rend.microservice.object.Response;
import kg.Cab.Rend.model.dto.CarDto;
import kg.Cab.Rend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileServiceFeting fileServiceFeting;
    @Autowired
    private CarServiceImpl carServiceImpl;

    @Override
    public CarDto uploaderPhoto(Long id, MultipartFile file) {
        CarDto carDto = carServiceImpl.findById(id);
        Response response = fileServiceFeting.upload(file);
        carDto.setPicketer(response.getDownloadUri());
        return null;
    }
}
