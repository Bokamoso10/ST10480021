/*
 * ============================================
 * LoginSystem2 Application
 * Unit Testing Class
 *
 * Part 1: Registration and Login Testing
 * Part 2: Message Feature Testing
 *
 * Author: Your Name
 * Date: 2026
 * ============================================
 */

package loginsystem2;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    LoginSystem2 login = new LoginSystem2();

    // Username correct
    @Test
    public void testCorrectUsername() {

        assertTrue(
                login.checkUserName("kyl_1")
        );
    }

    // Username incorrect
    @Test
    public void testIncorrectUsername() {

        assertFalse(
                login.checkUserName("kyle!!!!")
        );
    }

    // Password correct
    @Test
    public void testCorrectPassword() {

        assertTrue(
                login.checkPasswordComplexity("Ch&s3cake")
        );
    }

    // Password incorrect
    @Test
    public void testIncorrectPassword() {

        assertFalse(
                login.checkPasswordComplexity("password")
        );
    }

    // Cellphone correct
    @Test
    public void testCorrectCellphone() {

        assertTrue(
                login.checkCellPhoneNumber("+27838968976")
        );
    }

    // Cellphone incorrect
    @Test
    public void testIncorrectCellphone() {

        assertFalse(
                login.checkCellPhoneNumber("08966553")
        );
    }

    // Successful login
    @Test
    public void testSuccessfulLogin() {

        login.registerUser(
                "kyl_1",
                "Ch&s3cake",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertTrue(
                login.loginUser(
                        "kyl_1",
                        "Ch&s3cake"
                )
        );
    }

    // Failed login
    @Test
    public void testFailedLogin() {

        login.registerUser(
                "kyl_1",
                "Ch&s3cake",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertFalse(
                login.loginUser(
                        "wrong",
                        "wrong"
                )
        );
    }
}