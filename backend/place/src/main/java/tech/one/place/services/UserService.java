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
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    public String CreateUserInfo(User user){
        userRepo.save(user);
        return "User Created Successfully ";

    }
    public User register(User registerUser) {
        if (userRepo.existsByEmail(registerUser.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }




        User user = new User();

        user.setPassword(registerUser.getPassword());
        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setType(registerUser.getType());

        user.setVerified(false);



        User registeredUser = userRepo.save(user);



        return registeredUser;
    }

    public User getUserInfo(long userID){
        return userRepo.findById(userID).orElse(null);
    }
    public User DeleteUserInfo(long userId){
        User user = userRepo.findById(userId).get();
        userRepo.delete(user);
        return user;
    }
    public List<User> getALLUserInfo(){return userRepo.findAll();}
    public User updateUserInfo(User user, long id) {
       User exuser = userRepo.findById(id).get();

        exuser.setFirstName(user.getFirstName());
        exuser.setLastName(user.getLastName());
        exuser.setType(user.getType());
        exuser.setPassword(user.getPassword());
        exuser.setEmail(user.getEmail());

        return userRepo.save(exuser);
    }



}
