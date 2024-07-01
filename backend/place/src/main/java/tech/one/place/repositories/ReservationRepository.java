package tech.one.place.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.one.place.model.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{
    Reservation findByReservationId(int reservationId);
    Reservation findByRoomId(int roomId);
    Reservation findBySeatId(int seatId);
    Reservation findByUserId(int userId);
}
