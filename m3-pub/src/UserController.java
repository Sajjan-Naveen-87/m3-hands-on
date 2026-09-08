import java.util.HashMap;
import java.util.Map;

/**
 * Controller managing User accounts and lifecycle operations.
 */
public class UserController {
    private final Map<Long, User> users = new HashMap<>();

    public UserController() {}

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUserById(long id) {
        return users.get(id);
    }

    /**
     * Permanently closes a customer's account by marking the user inactive.
     *
     * @param id the ID of the user whose account is to be closed
     * @return true if the account was found and closed, false otherwise
     */
    public boolean closeAccount(long id) {
        User user = users.get(id);
        if (user != null && user.isActive()) {
            user.closeAccount();
            return true;
        }
        return false;
    }
}
