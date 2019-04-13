package com;

import com.domain.Users;
import com.domain.Usersdetails;
import com.service.UserService;
import com.service.UsersdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersdetailsService usersdetailsService;

    @GetMapping(value = "/users")
    public List<Users> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{email}")
    public Users getUser(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping(value = "/details/{email}")
    public Usersdetails getDetails(@PathVariable("email") String email){
        return usersdetailsService.getDetailsOfUserByEmail(email);
    }

    @RequestMapping(value = "/adduserdetails", method = RequestMethod.POST)
    public String addActor(@Valid @ModelAttribute("gender") String gender,
                           @ModelAttribute("country") String country,
                           @ModelAttribute("email") String email,
                           //String email,
                           BindingResult result,
                           ModelMap modelMap){
        if (!result.hasErrors()){
            usersdetailsService.adduserdetails(new Usersdetails(email,gender, country));
            return "success";
        } else {
            return "error";
        }
    }

}
