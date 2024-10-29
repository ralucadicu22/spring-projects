import com.example.login.LoginApplication;
import com.example.login.UserRepository;
import com.example.login.Users;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = LoginApplication.class)
public class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testCreateUser() {
        Users user = new Users();
        user.setEmail("dicuraluca95@yahoo.com");
        user.setPassword("1234");
        user.setFirstName("Raluca");
        user.setLastName("Dicu");

        Users savedUser = repository.save(user);
        Users existingUser = entityManager.find(Users.class, savedUser.getId());

        assertEquals(savedUser.getEmail(), existingUser.getEmail());
    }
}
