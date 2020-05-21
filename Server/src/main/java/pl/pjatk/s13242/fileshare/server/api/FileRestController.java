package pl.pjatk.s13242.fileshare.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.pjatk.s13242.fileshare.server.dto.UploadResponse;
import pl.pjatk.s13242.fileshare.server.repos.AccountRepository;
import pl.pjatk.s13242.fileshare.server.repos.FileRepository;

@RestController
//@RequestMapping("/api/")
public class FileRestController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private FileRepository fileRepository;


    @PostMapping("/uploadFile")
    public UploadResponse uploadFile(@RequestParam("file") MultipartFile file) {

        UploadResponse response = new UploadResponse();

        return response;
    }



//        String fileName = fileStorageService.storeFile(file);

//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();

//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }


}
