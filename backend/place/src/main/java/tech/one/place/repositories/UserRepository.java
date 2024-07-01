package tech.one.place.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.one.place.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);
    User findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
