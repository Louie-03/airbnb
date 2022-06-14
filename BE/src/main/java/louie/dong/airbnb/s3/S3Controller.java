package louie.dong.airbnb.s3;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping
    public String form() {
        return "form";
    }

    @ResponseBody
    @PostMapping
    public void uploadFile(@RequestParam MultipartFile multipartFile)
        throws IOException {
        s3Service.saveUploadFile(multipartFile);
    }

}
