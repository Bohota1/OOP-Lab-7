package Code;

import java.io.File;
import java.io.IOException;

public class AdminUser extends User implements AccessControl {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public String getUserType() {
        return "Admin";
    }

    @Override
    public void viewFile() throws IOException {
        new RegularUser(getUserID(), getUsername(), getEmail(), getPassword()).viewFile();
    }

    @Override
    public void addUser(User user) throws IOException {
        new PowerUser(getUserID(), getUsername(), getEmail(), getPassword()).addUser(user);
    }

    @Override
    public void updateUser(String username, User updatedUser) {
        // Implementation for updating user details in CSV file.
        System.out.println("User details updated for: " + username);
    }

    @Override
    public void renameFile(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("File renaming failed.");
        }
    }
}
