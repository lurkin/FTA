package pl.pjatk.s13242.fileshare.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.s13242.fileshare.server.dto.FileTree;
import pl.pjatk.s13242.fileshare.server.entities.File;
import pl.pjatk.s13242.fileshare.server.repos.FileRepository;

import java.util.*;

@RestController
public class DocumentRestController {

    @Autowired
    private FileRepository repository;

    @RequestMapping("/file/{id}")
    public File findReservation(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/file")
    public File createFile(@RequestBody File file)
    {

        return repository.save(file);
    }

    @GetMapping("/tree")
    public FileTree getFileTree()
    {
    // TODO
        FileTree tree = new FileTree();
        tree.setFileName("alalal");
        tree.setDirectory(true);


        FileTree file1 = new FileTree();
        file1.setFileName("file1.pdf");
        file1.setDirectory(false);

        List children =  new ArrayList<FileTree>();
        children.add(file1);

        tree.setChildren(children);


        return tree;
    }





}
