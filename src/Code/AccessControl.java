package Code;

import java.io.IOException;

public interface AccessControl {
    void viewFile() throws IOException;

    void addUser(User user) throws IOException;

    void updateUser(String username, User updatedUser) throws IOException;

    void renameFile(String oldName, String newName) throws IOException;
}
