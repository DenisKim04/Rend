package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.CarDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    CarDto uploaderPhoto (Long id, MultipartFile file);

}
