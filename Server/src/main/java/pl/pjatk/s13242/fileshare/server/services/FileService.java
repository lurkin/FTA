package pl.pjatk.s13242.fileshare.server.services;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import pl.pjatk.s13242.fileshare.server.entities.File;
import pl.pjatk.s13242.fileshare.server.repos.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.FileObject;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File getFile(long id) {
        return fileRepository.findById(id).get();
    }

    public List<File> findAll() {
        return fileRepository.findAll();
    }

    public File save(File file) {
        return fileRepository.save(file);
    }



}
