package Code;

import java.util.HashMap;
import java.util.Map;

public class UserManager implements Authentication {
    private static UserManager instance;
    private final Map<String, User> users;

    private UserManager() {
        this.users = new HashMap<>();
        // Load users from CSV (not shown for brevity)
    }

    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }
}
