package pl.pjatk.s13242.fileshare.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.s13242.fileshare.server.entities.Account;
import pl.pjatk.s13242.fileshare.server.entities.File;
import pl.pjatk.s13242.fileshare.server.repos.AccountRepository;
import pl.pjatk.s13242.fileshare.server.services.FileService;
import pl.pjatk.s13242.fileshare.server.services.SecurityService;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private FileService fileService;



    @RequestMapping("/showReg")
    public String showRegistrationPage()
    {
        return "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("account") Account account){


        account.setPassword(encoder.encode(account.getPassword()));
        accountRepository.save(account);
        return "login";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {

        boolean loginResponse = securityService.login(email, password);

        String username = "init";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }



        Account account  = accountRepository.findByEmail(username);
        //if(account != null && account.getPassword().equals(password)) {
        if(loginResponse){
            List<File> files = fileService.findAll();
            modelMap.addAttribute("list", files);
            return "fileList";
        }
        else
        {
            modelMap.addAttribute("msg", "Login failed. Try again.");
        }
        return "login";
    }



}
