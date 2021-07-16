package kg.Cab.Rend.microservice;



import kg.Cab.Rend.microservice.object.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "${micro.file-service.name}",url = "micro.file-service.url")
public interface FileServiceFeting {

    @PostMapping(value = "/api/v1/file/upload",consumes = "multipart/form-date")
    public Response upload(@RequestPart MultipartFile file);


}
