package tech.one.place.services;
import tech.one.place.model.User;
import tech.one.place.repositories.UserRepository;
import tech.one.place.model.Seat;
import tech.one.place.repositories.SeatRepository;
import tech.one.place.model.Room;
import tech.one.place.repositories.RoomRepository;
import tech.one.place.model.Reservation;
import tech.one.place.repositories.ReservationRepository;



import org.springframework.beans.factory.annotation.Autowired;


import com.jayway.jsonpath.internal.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import java.util.List;
@Service

public class SeatService {
    private final SeatRepository seatRepo;

    public SeatService(SeatRepository seatRepo) {
        this.seatRepo = seatRepo;
    }
    public String createSeatInfo(Seat seat){
        seatRepo.save(seat);
        return("seat created seccessfuly");
    }
    public Seat registerSeat(Seat registerSeat){
        if (seatRepo.existsById(registerSeat.getId())) {
            throw new IllegalArgumentException("Seat already exists");
        }
        Seat seat = new Seat();

        seat.setStatus(registerSeat.getStatus());
        seat.setIdRoom(registerSeat.getIdRoom());
        Seat registeredSeat = seatRepo.save(seat);




        return registeredSeat;
    }
    public Seat getSeatInfo(long seatID){
        return seatRepo.findById(seatID).orElse(null);
    }
    public List<Seat> getALLSeatInfo(){return seatRepo.findAll();}
    public Seat DeleteSeatInfo(long seatId){
        Seat seat = seatRepo.findById(seatId).get();
        seatRepo.delete(seat);
        return seat;
    }
    public Seat updateSeat(long seatID, Seat seat){
        Seat existingSeat = seatRepo.findById(seatID).orElse(null);
        existingSeat.setStatus(seat.getStatus());
        existingSeat.setIdRoom(seat.getIdRoom());
        return seatRepo.save(existingSeat);
    }


}
