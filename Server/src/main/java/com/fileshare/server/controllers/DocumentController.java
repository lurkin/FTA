package com.fileshare.server.controllers;

import com.fileshare.server.entities.File;
import com.fileshare.server.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        List<File> files = fileService.findAll();
        if (files == null) System.out.println("asd");
        modelMap.addAttribute("list", files);

        return "fileList";
    }

    @GetMapping("/upload")
    public String doUpload(){
        return "fileUpload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile,
                             @RequestParam("id") Long id,
                             ModelMap modelMap) throws IOException {

        File file = new File();
        file.setId(id);
        file.setName(multipartFile.getResource().getFilename());
        file.setData(multipartFile.getBytes());
        file.setPath(multipartFile.getResource().getFilename());

        fileService.save(file);
        List<File> list = fileService.findAll();


        modelMap.addAttribute("list", list);

        return "/fileList";

    }

    @GetMapping("/download")
    public StreamingResponseBody downloadFile(@RequestParam("id") Long id,
                                              HttpServletResponse response) {
        File file = fileService.getFile(id);
        System.out.println("syso");
        byte[] data = file.getData();

        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        return o -> o.write(data);
    }
}
