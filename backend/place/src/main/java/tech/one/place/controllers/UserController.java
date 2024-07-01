package tech.one.place.controllers;



//import Dto.RegisterUser;
import tech.one.place.model.User;
import tech.one.place.repositories.UserRepository;
import tech.one.place.model.Seat;
import tech.one.place.repositories.SeatRepository;
import tech.one.place.model.Room;
import tech.one.place.repositories.RoomRepository;
import tech.one.place.model.Reservation;
import tech.one.place.repositories.ReservationRepository;
import tech.one.place.services.UserService;
import tech.one.place.services.ReservationService;
import tech.one.place.services.RoomService;
import tech.one.place.services.SeatService;
import jakarta.validation.Valid;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200/")

public class UserController {
    @Autowired
    private  UserService userService;
    @PostMapping
    public ResponseEntity<Object> createUserDetails(@RequestBody @Valid User user){
        // Register the user


            User registeredUser = userService.register(user);

            return ResponseEntity.ok(registeredUser);




    }

    @GetMapping("/{UserID}")
    public ResponseEntity<tech.one.place.model.User> getUserDetails(@PathVariable("UserID") int userID) {


        tech.one.place.model.User user = userService.getUserInfo(userID);

            System.out.println(user);
            return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @DeleteMapping ("/{userID}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable("userID") int userID){

            this.userService.DeleteUserInfo(userID);


            return new ResponseEntity<>("User Deleted Successfully", HttpStatus.NO_CONTENT);


    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUserDetails() {



            List<User> users = userService.getALLUserInfo();

            return ResponseEntity.ok(users);




    }



}

