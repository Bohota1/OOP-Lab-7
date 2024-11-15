package Code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegularUser extends User implements AccessControl {
    public RegularUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public String getUserType() {
        return "Regular";
    }

    @Override
    public void viewFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("User.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("Regular users cannot add users.");
    }

    @Override
    public void updateUser(String username, User updatedUser) {
        throw new UnsupportedOperationException("Regular users cannot update users.");
    }

    @Override
    public void renameFile(String oldName, String newName) {
        throw new UnsupportedOperationException("Regular users cannot rename files.");
    }
}
