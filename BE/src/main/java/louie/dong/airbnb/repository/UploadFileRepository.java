package louie.dong.airbnb.repository;

import louie.dong.airbnb.s3.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {

}
