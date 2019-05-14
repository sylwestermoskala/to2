package com.config;

import com.config.domain.Reservation;
import org.slf4j.Logger;
import com.config.domain.User;
import com.config.service.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;


@Controller
public class MyController {

    private final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsersdetailsService usersdetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoutesService routesService;

    @Autowired
    private ReservationService reservationService;


    @GetMapping(value = "/userdetail")
    public String detail(HttpServletRequest request,
                         ModelMap modelMap){
        try {
            modelMap.addAllAttributes(usersdetailsService.getDetails(request.getUserPrincipal().getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userdetail";
    }

    @RequestMapping(value = "/")
    public String homePage(){
        return "homePage";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }


    @RequestMapping(value = "/log")
    public String logPage() {
        return "log";
    }

    @RequestMapping(value = "/registrationPage")
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "registrationPage";
    }

    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        try {
            modelMap.addAttribute("routes", routesService.getRoute());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminPage";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addusers(@ModelAttribute("email") String email,
                           @ModelAttribute("password") String password,
                           ModelMap modelMap){ // bo z posta

        String sqlUser = String.format("INSERT INTO users(email,password,enabled) VALUES ('%s','%s',true)", email, password);
        jdbcTemplate.execute(sqlUser);
        String sqlRole = String.format("INSERT INTO user_roles(email,role) VALUES ('%s','%s')",email, "ROLE_USER");
        jdbcTemplate.execute(sqlRole);

        return "login";
    }


    @RequestMapping(value = "/adduserdetails", method = RequestMethod.POST)
    public String addActor(@ModelAttribute("gender") String gender,
                           @ModelAttribute("country") String country,
                           @ModelAttribute("email") String email,
                           ModelMap modelMap) {
        try {
            modelMap.addAllAttributes(usersdetailsService.addUserDetails(email, gender, country));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "redirect:/userdetail";
    }

    @RequestMapping(value = "/route", method = RequestMethod.GET)
    public String route(ModelMap modelMap){
        try {
            modelMap.addAttribute("routes", routesService.getRoute());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/route";
    }

    // delete user
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id,
                             final RedirectAttributes redirectAttributes) {

        logger.debug("deleteUser() : {}", id);

        try {
            routesService.deleteRouteById2(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/adminPage";

    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation(ModelMap modelMap){
        try {
            modelMap.addAttribute("responseReservation", reservationService.getReservations());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/reservation";
    }


    //show update form
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

        logger.debug("showUpdateUserForm() : {}", id);

        try {
            model.addAttribute("xxx", routesService.getRouteById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/routeForm";
    }


    @RequestMapping(value = "/updateRoute", method = RequestMethod.POST)
    public String updateRoute(
            @ModelAttribute("id") String id,
            @ModelAttribute("date") String date,
            @ModelAttribute("distance") String distance,
            @ModelAttribute("start_location") String start_location,
            @ModelAttribute("end_location") String end_location,
            //String email,
            ModelMap modelMap) {
        try {
            modelMap.addAllAttributes(routesService.routeUpdate(id, date, distance, start_location, end_location));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "redirect:/adminPage";
    }

    @RequestMapping(value = "/routeForm")
    public String routeFormPage() {
        return "routeForm";
    }

    @RequestMapping(value = "/addRoute", method = RequestMethod.GET)
    public String addFormPage() {
        return "addRoute";
    }

    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    public String addRoute(
            @ModelAttribute("id") String id,
            @ModelAttribute("date") String date,
            @ModelAttribute("distance") String distance,
            @ModelAttribute("start_location") String start_location,
            @ModelAttribute("end_location") String end_location,
            //String email,
            ModelMap modelMap) {
        try {
            modelMap.addAllAttributes(routesService.routeAdd(id, date, distance, start_location, end_location));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "redirect:/adminPage";
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("employee") Reservation reservation) {

        ModelAndView model = new ModelAndView("redirect:/route");
        try {
            reservationService.addReservation(reservation);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String message = "User registration successful!";
        model.addObject("message", message);
        return model;
    }
}