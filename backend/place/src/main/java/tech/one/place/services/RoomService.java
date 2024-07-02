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

public class RoomService {
    private final RoomRepository roomRepo;

    public RoomService(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }


    public String createRoomInfo(Room room){
        roomRepo.save(room);
        return("room created seccessfuly");
    }
    public Room registerRoom(Room registerRoom){
        if (roomRepo.existsById(registerRoom.getId())) {
            throw new IllegalArgumentException("Room already exists");
        }
        Room room = new Room();

        room.setStatus(registerRoom.getStatus());
        room.setCapacity(registerRoom.getCapacity());
        Room registeredRoom = roomRepo.save(room);




        return registeredRoom;
    }
    public List<Room> getAllRooms(){return roomRepo.findAll();}
    public Room getRoomInfo(long Id){
        return roomRepo.findById(Id).orElse(null);
    }
    public Room deleteRoom(long Id){
        Room room = roomRepo.findById(Id).get();
        roomRepo.delete(room);
        return room;

    }
    public Room updateRoom(long Id, Room room){
        Room exroom = roomRepo.findById(Id).get();
        exroom.setStatus(room.getStatus());
        exroom.setCapacity(room.getCapacity());
        return roomRepo.save(exroom);


    }



}
