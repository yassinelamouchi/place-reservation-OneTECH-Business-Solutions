package tech.one.place.services;
import tech.one.place.model.Reservation;
import tech.one.place.model.Room;
import tech.one.place.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
        Reservation reservation = new Reservation();
        reservation.setDate(res.getDate());
        reservation.setIdSeat(res.getIdSeat());
        reservation.setIdUser(res.getIdUser());
        Reservation registeredReservation = reservationRepo.save(reservation);
        return registeredReservation;
    }
    public Reservation updateReservation(long reservationId,Reservation res){
        Reservation reservation = reservationRepo.findById(reservationId).get();
        reservation.setDate(res.getDate());
        reservation.setIdSeat(res.getIdSeat());
        reservation.setIdUser(res.getIdUser());
        return reservationRepo.save(reservation);
    }
    public Reservation getReservation(long Id){
        return reservationRepo.findById(Id).get();
    }
    public List<Reservation> getAllReservations(){
        return  reservationRepo.findAll();

    }
    public Reservation deleteReservation(long Id){
        Reservation res = reservationRepo.findById(Id).get();
        reservationRepo.deleteById(Id);
        return res;
    }
}
