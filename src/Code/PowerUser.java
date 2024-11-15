package Code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PowerUser extends User implements AccessControl {
    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public String getUserType() {
        return "Power";
    }

    @Override
    public void viewFile() throws IOException {
        new RegularUser(getUserID(), getUsername(), getEmail(), getPassword()).viewFile();
    }

    @Override
    public void addUser(User user) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("User.csv", true))) {
            writer.write(String.format("%s,%s,%s,%s,%s%n", user.getUserID(), user.getUsername(),
                    user.getEmail(), user.getPassword(), user.getUserType()));
        }
    }

    @Override
    public void updateUser(String username, User updatedUser) {
        throw new UnsupportedOperationException("Power users cannot update users.");
    }

    @Override
    public void renameFile(String oldName, String newName) {
        throw new UnsupportedOperationException("Power users cannot rename files.");
    }
}
