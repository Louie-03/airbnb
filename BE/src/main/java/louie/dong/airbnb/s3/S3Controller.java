package louie.dong.airbnb.s3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping
    public String form() {
        return "form";
    }

    @ResponseBody
    @PostMapping("/{userId}/image")
    public String updateUserImage(@RequestParam("images") MultipartFile multipartFile) {
        s3Service.uploadFiles(multipartFile, )
        return "ok";
    }
}
