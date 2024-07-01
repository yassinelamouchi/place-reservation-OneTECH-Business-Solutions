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
@RequestMapping("/api/seat")
@CrossOrigin(origins = "http://localhost:4200/")

public class SeatController {
    @Autowired
    private  SeatService seatService;
    @PostMapping
    public ResponseEntity<Object> createSeatDetails(@RequestBody @Valid Seat seat){



        Seat registeredSeat = seatService.registerSeat(seat);

        return ResponseEntity.ok(registeredSeat);




    }
    @GetMapping("/{seatID}")
    public ResponseEntity<tech.one.place.model.Seat> getSeatDetails(@PathVariable("SeatID") int seatID) {


        Seat seat = seatService.getSeatInfo(seatID);

        System.out.println(seat);
        return new ResponseEntity<>(seat, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeatDetails() {



        List<Seat> seats = seatService.getALLSeatInfo();

        return ResponseEntity.ok(seats);




    }
}
