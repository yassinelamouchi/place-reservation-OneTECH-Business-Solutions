package tech.one.place.services;
import tech.one.place.model.Reservation;
import tech.one.place.model.Room;
import tech.one.place.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import tech.one.place.model.User;
import tech.one.place.Dto.RegisterUser;
import tech.one.place.repositories.UserRepository;





@Service
public class AuthService {
    @Autowired
    private  UserRepository userRepo;

    public User register(RegisterUser registerUser) {
        if (userRepository.existsByEmail(registerUser.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }


        Field field = fieldRepository.findById((long) registerUser.getFieldId()).orElse(null);

        User user = new User();

        user.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setRole(registerUser.getRole());
        user.setBirthDate(registerUser.getBirthDate());
        user.setVerified(false);
        user.setField(field);


        User registeredUser = userRepository.save(user);

        try {
            emailService.sendHtmlMessage(user.getEmail(), "Welcome to ENICAR Social Media", "emailVerification.html", registeredUser);

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

        return registeredUser;
    }





}
