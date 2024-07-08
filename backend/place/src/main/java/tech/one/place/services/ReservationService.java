package tech.one.place.services;
import tech.one.place.model.Reservation;
import tech.one.place.model.Room;
import tech.one.place.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepo;

    public ReservationService(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }
    public Reservation crateReservation(Reservation reservation){
        reservationRepo.save(reservation);
        return reservation;
    }
    public Reservation register(Reservation res){
        if (reservationRepo.existsById(res.getId())) {
            throw new IllegalArgumentException("Room already exists");
        }

        Room room = new Room();

        room.setStatus(registerRoom.getStatus());
        room.setCapacity(registerRoom.getCapacity());
        Room registeredRoom = roomRepo.save(room);




        return registeredRoom;
    }
}
