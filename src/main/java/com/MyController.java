package com;

import com.domain.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersdetailsService usersdetailsService;

    @Autowired
    private RoutesService routesService;

    @Autowired
    private ReservationService reservationService;


    @GetMapping(value = "/users")
    public List<Users> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{email}")
    public Users getUser(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping(value = "/details/{email}")
    public Usersdetails getDetails(@PathVariable("email") String email) {
        return usersdetailsService.getDetailsOfUserByEmail(email);
    }

    @RequestMapping(value = "/adduserdetails", method = RequestMethod.POST)
    public String addActor(@Valid @ModelAttribute("gender") String gender,
                           @ModelAttribute("country") String country,
                           @ModelAttribute("email") String email,
                           BindingResult result,
                           ModelMap modelMap) {
        if (!result.hasErrors()) {
            usersdetailsService.adduserdetails(new Usersdetails(email, gender, country));
            return "success";
        } else {
            return "error";
        }
    }


    @GetMapping(value = "/routes")
    public List<Routes> getRoutes() {
        return routesService.getRoutes();
    }

    @GetMapping(value = "/routes/{id}")
    public Routes getRoutesById(@PathVariable("id") int id) {
        return routesService.findRouteById(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        routesService.deleteRouteById(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/updateRoute", method = RequestMethod.POST)
    public String updateRoute(
            @ModelAttribute("id") int id,
            @ModelAttribute("date") String date,
            @ModelAttribute("distance") int distance,
            @ModelAttribute("start_location") String start_location,
            @ModelAttribute("end_location") String end_location,
            BindingResult result,
            ModelMap modelMap) {
        if (!result.hasErrors()) {
            routesService.updateRoute(new Routes(id, date, distance, start_location, end_location));
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    public String addRoute(
            @ModelAttribute("id") int id,
            @ModelAttribute("date") String date,
            @ModelAttribute("distance") int distance,
            @ModelAttribute("start_location") String start_location,
            @ModelAttribute("end_location") String end_location,
            BindingResult result,
            ModelMap modelMap) {
        if (!result.hasErrors()) {
            routesService.addRoute(new Routes(id, date, distance, start_location, end_location));
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/reservation/{id}")
    public Reservation getDetails(@PathVariable("id") int id) {
        return reservationService.findReservationByRoute(id);
    }

    @GetMapping(value = "/reservation")
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Reservation reservation) {
        reservationService.addreservation(reservation);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

}
