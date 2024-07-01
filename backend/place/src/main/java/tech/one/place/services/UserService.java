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
public class UserService {
    private final UserRepository userRepo;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    public String CreateUserInfo(User user) {
        userRepo.save(user);
        return "User Created Successfully ";
    }
    public String UpdateUserInfo(User user) {
        userRepo.save(user);
        return "User Updated Successfully ";
    }
    public String DeleteUserInfo(User user) {
        userRepo.delete(user);
        return "User Deleted Successfully ";
    }
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }


}
