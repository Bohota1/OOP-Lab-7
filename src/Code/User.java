package Code;

public abstract class User {
    private final String userID;
    private final String username;
    private final String email;
    private final String password;

    public User(String userID, String username, String email, String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getUserType();
}
