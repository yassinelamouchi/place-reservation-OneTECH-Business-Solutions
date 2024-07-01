package tech.one.place.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.one.place.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
    Room findByRoomId(int roomId);
    Room findByRoomName(String roomName);

}
