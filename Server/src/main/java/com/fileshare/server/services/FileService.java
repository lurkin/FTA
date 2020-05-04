package com.fileshare.server.services;

import com.fileshare.server.entities.File;
import com.fileshare.server.repos.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
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
