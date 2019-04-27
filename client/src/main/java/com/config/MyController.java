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
    private QuestionsService questionsService;

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

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/adminn";
        }
        return "login";
    }



    @RequestMapping(value = "/adminPage", method = RequestMethod.POST)
    public String adminPage(@ModelAttribute("email") String email,
                           @ModelAttribute("password") String password,
                           ModelMap modelMap) { // bo z posta

//        if (userService.emailExist(email)) {
//            return "redirect:/registrationPage";
//        }

        String sqlUser = String.format("INSERT INTO users(email,password,enabled) VALUES ('%s','%s',true)", email, password);
        jdbcTemplate.execute(sqlUser);
        String sqlRole = String.format("INSERT INTO user_roles(email,role) VALUES ('%s','%s')", email, "ROLE_USER");
        jdbcTemplate.execute(sqlRole);
//        List<User> userList = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(User.class));
//        modelMap.addAttribute("users",userList);

        return "login";
    }



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/adminn", method = RequestMethod.GET)
    public String adminn() {
        return "adminn";
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


    @RequestMapping(value = "/correct/answer")
    public ResponseEntity<Boolean> correctAnswer (@RequestParam(name = "id") Integer answerId,
                                         @RequestParam(name = "answer") String choosenAnswer) {
        String sql = String.format("SELECT answer from questions where id=%d", answerId);
        String result =  jdbcTemplate.queryForObject(sql, String.class);
        if(result.equals(choosenAnswer))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.OK);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addusers(@ModelAttribute("email") String email,
                           @ModelAttribute("password") String password,
                           ModelMap modelMap){ // bo z posta

//        if (userService.emailExist(email)) {
//            return "redirect:/registrationPage";
//        }

        String sqlUser = String.format("INSERT INTO users(email,password,enabled) VALUES ('%s','%s',true)", email, password);
        jdbcTemplate.execute(sqlUser);
        String sqlRole = String.format("INSERT INTO user_roles(email,role) VALUES ('%s','%s')",email, "ROLE_USER");
        jdbcTemplate.execute(sqlRole);
//        List<User> userList = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(User.class));
//        modelMap.addAttribute("users",userList);

        return "login";
    }



    @RequestMapping(value = "/adduserdetails", method = RequestMethod.POST)
    public String addActor(@ModelAttribute("gender") String gender,
                           @ModelAttribute("country") String country,
                           @ModelAttribute("email") String email,
                           //String email,
                           ModelMap modelMap) {
        try {
            modelMap.addAllAttributes(usersdetailsService.addUserDetails(email, gender, country));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "redirect:/userdetail";
    }



    ////////////////////

    @RequestMapping(value = "/quiz1")
    public String quiz(ModelMap modelMap){
        try {
            modelMap.addAttribute("questions",questionsService.getQuestions());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "quiz1";
    }

    @RequestMapping(value = "/quiz1/{category}")
    public String quiz(ModelMap modelMap, @ModelAttribute("category") String category) {
        try {
            modelMap.addAttribute("questions", questionsService.getQuestionsByCategory(category));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "quiz1";
    }


    /////////////////////////

    @RequestMapping(value = "/route", method = RequestMethod.GET)
    public String route(ModelMap modelMap){
        try {
            modelMap.addAttribute("routes", routesService.getRoute());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/route";
    }
    ////////////////////

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable String id, ModelMap modelMap){
//        try {
//            modelMap.addAttribute("routes", routesService.deleteRouteById(id));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/route";
//    }

    ///true
//    @RequestMapping(value="/delete/{id}")
//    public String removeEmployee(@PathVariable("id") Integer id) {
//        try {
//            this.routesService.delete(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/route";
//    }

//    @DeleteMapping("/delete/{id}")
//    ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
//
//        try {
//            routesService.delete(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ResponseEntity.noContent().build();
//    }

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

        return "redirect:/route";

    }

//    @RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
//    @ResponseBody
//    public void deleteStudent(@PathVariable("id") String id) {
//        System.out.println("In deleteStudentRecord");
//        try {
//            routesService.delete(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    @DeleteMapping(value = "/delete/{id}")
//    @RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public @ResponseBody String deleteUser(@PathVariable("id") Integer idx, final RedirectAttributes redirectAttributes) {
//
//        //logger.debug("Delete user with Id {}", idx);
//
//        redirectAttributes.addFlashAttribute("css", "Success");
//        redirectAttributes.addFlashAttribute("msg", "The user is deleted");
//
//        // delete the user
//        try {
//            routesService.delete(idx);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/route";
//    }



    //RESERVATION//
//    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
//    public String resPage() {
//        return "reservation";
//    }
//
//    @RequestMapping(value = "/route/reservation", method = RequestMethod.POST)
//    public String resPage(
//            @ModelAttribute("route_number") int route_number,
//                           @ModelAttribute("distance") int distance,
//                           @ModelAttribute("start_location") String start_location,
//                           @ModelAttribute("end_location") String end_location,
//                           //String email,
//                           ModelMap modelMap) {
//        try {
//            modelMap.addAllAttributes(reservationService.addReservation(route_number, distance, start_location, end_location));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return "/reservation";
//    }


    @RequestMapping(value = "/route/reservation", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute Reservation userTO) {

        ModelAndView model = new ModelAndView("redirect:/route");
        try {
            reservationService.addReservation(userTO);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String message = "User registration successful!";
        model.addObject("message", message);
        return model;
    }

//    @RequestMapping(value = "/route/reservation", method = RequestMethod.POST)
//    public String resPage(
//            @ModelAttribute("routenumber") String routenumber,
//            @ModelAttribute("distance") String distance,
//            @ModelAttribute("start_location") String start_location,
//            @ModelAttribute("end_location") String end_location,
//            //String email,
//            ModelMap modelMap) {
//        try {
//            modelMap.addAllAttributes(reservationService.addReservation(routenumber, distance, start_location, end_location));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/route";
//    }



    ////////good/////////////////////////
    @GetMapping(value = "/reservation")
    public String detailReser(HttpServletRequest request,
                         ModelMap modelMap){
        try {
            modelMap.addAllAttributes(reservationService.getDetailsReser(request.getUserPrincipal().getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "reservation";
    }
}