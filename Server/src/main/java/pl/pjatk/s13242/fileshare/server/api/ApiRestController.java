package pl.pjatk.s13242.fileshare.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.s13242.fileshare.server.dto.FileTree;
import pl.pjatk.s13242.fileshare.server.entities.Account;
import pl.pjatk.s13242.fileshare.server.entities.File;
import pl.pjatk.s13242.fileshare.server.repos.AccountRepository;
import pl.pjatk.s13242.fileshare.server.repos.FileRepository;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class DocumentRestController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private FileRepository fileRepository;


//    @PostMapping("/file")
//    public File createFile(@RequestBody File file)
//    {
//
//        return fileRepository.save(file);
//    }

    @GetMapping("/tree")
    public FileTree getFileTree()
    {
        String username = "init";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        Account account = accountRepository.findByEmail(username);




    // TODO
        FileTree tree = new FileTree();
        tree.setFileName(username);
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
