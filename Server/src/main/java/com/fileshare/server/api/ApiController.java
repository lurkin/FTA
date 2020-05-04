package com.fileshare.server.api;

import com.fileshare.server.entities.File;
import com.fileshare.server.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/")
public class ApiController {

    @Autowired
    private FileService fileService;

    @GetMapping("/get")
    public StreamingResponseBody getFile(@RequestParam("id") int id,
                                         HttpServletResponse response) {
        File file = fileService.getFile(id);
        byte[] data = file.getData();
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        return o -> o.write(data);
    }

}
