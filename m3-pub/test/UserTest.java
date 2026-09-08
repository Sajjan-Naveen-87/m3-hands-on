import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void closeAccountPermanentlyDeactivatesUser() {
        User user = new User(1L, "Alice Smith", "alice@example.com", true);
        assertTrue(user.isActive(), "Account should initially be active");

        user.closeAccount();
        assertFalse(user.isActive(), "Account should be permanently closed/inactive");
    }

    @Test
    void userControllerClosesAccountSuccessfully() {
        UserController controller = new UserController();
        User user = new User(10L, "Bob Jones", "bob@example.com", true);
        controller.registerUser(user);

        boolean result = controller.closeAccount(10L);
        assertTrue(result, "closeAccount should return true when account is found and active");
        assertFalse(controller.getUserById(10L).isActive(), "User should be marked inactive after closure");
    }

    @Test
    void userControllerCloseNonExistentAccountReturnsFalse() {
        UserController controller = new UserController();
        boolean result = controller.closeAccount(9999L);
        assertFalse(result, "closeAccount should return false for unknown account");
    }
}
