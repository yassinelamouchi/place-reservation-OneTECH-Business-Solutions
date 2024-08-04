package tech.one.place.Utils;

import org.springframework.stereotype.Component;
import tech.one.place.model.User;
import tech.one.place.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;
@Component
public class DatabaseInitializer implements CommandLineRunner  {
    private final UserRepository userRepo;

    public DatabaseInitializer(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        if(userRepo.count() > 0){
            return;
        }
        this.userSetup();


    }

    public void userSetup(){
        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("admin");
        user.setType("admin");
        userRepo.save(user);
    }
}
