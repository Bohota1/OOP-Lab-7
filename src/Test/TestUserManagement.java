package Test;

import Code.AdminUser;
import Code.PowerUser;
import Code.RegularUser;
import Code.UserManager;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserManagement {
    private UserManager manager;

    @BeforeEach
    public void setUp() {
        manager = UserManager.getInstance();
    }

    @Test
    public void testRegularUserViewFile() {
        RegularUser user = new RegularUser("1", "john", "john@example.com", "pass");
        assertDoesNotThrow(user::viewFile);
    }

    @Test
    public void testPowerUserAddUser() throws IOException {
        PowerUser user = new PowerUser("2", "jane", "jane@example.com", "pass");
        User newUser = new RegularUser("3", "mark", "mark@example.com", "1234");
        assertDoesNotThrow(() -> user.addUser(newUser));
    }

    @Test
    public void testAdminRenameFile() {
        AdminUser user = new AdminUser("4", "admin", "admin@example.com", "admin");
        assertDoesNotThrow(() -> user.renameFile("User.csv", "UserBackup.csv"));
    }
}

