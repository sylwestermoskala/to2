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
    private QuestionsService questionsService;

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
                           //String email,
                           BindingResult result,
                           ModelMap modelMap) {
        if (!result.hasErrors()) {
            usersdetailsService.adduserdetails(new Usersdetails(email, gender, country));
            return "success";
        } else {
            return "error";
        }
    }


    ///////////

    @GetMapping(value = "/questions")
    public List<Questions> getQuestions() {
        return questionsService.getQuestions();
    }

    @GetMapping(value = "/questions/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable("category") String category) {
        return questionsService.getQuestionsByCategory(category);
    }


    /////////////////

    @GetMapping(value = "/routes")
    public List<Routes> getRoutes() {
        return routesService.getRoutes();
    }

//    @GetMapping(value = "/route/{category}")
//    public List<Routes> getRouteByCategory(@PathVariable("category") String category){
//        return routeService.getRouteByCategory(category);
//    }

    /////////////////////

    @GetMapping(value = "/routes/{id}")
    public Routes getRoutesById(@PathVariable("id") int id) {
        return routesService.findRouteById(id);
    }


    /////////////////////

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    public @ResponseBody void deleteTrip(@PathVariable("id") int id) {
//        routesService.deleteRouteById(id);
//    }

    ///////////////////
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        routesService.deleteRouteById(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }



    ///////////////////////////////////RESERVATION////////////////////////////////////////
    @RequestMapping(value = "/route/reservation", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Reservation reservation) {
        reservationService.put(reservation);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }


//    @RequestMapping(value = "/route/reservation", method = RequestMethod.POST)
//    public String createProduct(@Valid @ModelAttribute("route_number") int route_number,
//                           @ModelAttribute("distance") int distance,
//                           @ModelAttribute("start_location") String start_location,
//                                @ModelAttribute("end_location") String end_location,
//                           BindingResult result,
//                           ModelMap modelMap) {
//        if (!result.hasErrors()) {
//            reservationService.put(new Reservation(route_number, distance, start_location, end_location));
//            return "success";
//        } else {
//            return "error";
//        }
//    }


    ///////good//////////
    @GetMapping(value = "/reservation/{routenumber}")
    public Reservation getDetailsReser(@PathVariable("routenumber") int routenumber) {
        return reservationService.findReservationByRoute(routenumber);
    }
}

