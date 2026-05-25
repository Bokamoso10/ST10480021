/*
 * ============================================
 * LoginSystem2 Application
 * Part 1: Registration and Login Feature
 * Part 2: Sending Messages Feature
 *
 * This class handles:
 * - Username validation
 * - Password validation
 * - Cell phone validation
 * - User registration
 * - User login authentication
 *
 * Author: Your Name
 * Date: 2026
 * ============================================
 */

package loginsystem2;

import java.util.regex.Pattern;

public class LoginSystem2 {

    // User variables
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Username validation
    public boolean checkUserName(String username) {

        return username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity(String password) {

        String regex =
                "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

        return Pattern.matches(regex, password);
    }

    // Cell phone validation
    // Regex reference:
    // https://regex101.com/
    public boolean checkCellPhoneNumber(String number) {

        String regex = "^\\+27\\d{9}$";

        return Pattern.matches(regex, number);
    }

    // Register user
    public String registerUser(String username,
                               String password,
                               String cellPhone,
                               String firstName,
                               String lastName) {

        if (!checkUserName(username)) {

            return "Username is not correctly formatted; "
                    + "please ensure that your username contains "
                    + "an underscore and is no more than five "
                    + "characters in length.";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted; "
                    + "please ensure that the password contains "
                    + "at least eight characters, a capital letter, "
                    + "a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {

            return "Cell phone number incorrectly formatted "
                    + "or does not contain international code.";
        }

        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User successfully registered.";
    }

    // Login verification
    public boolean loginUser(String username, String password) {

        return this.username.equals(username)
                && this.password.equals(password);
    }

    // Return login message
    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {

            return "Welcome "
                    + firstName + " "
                    + lastName
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect, "
                    + "please try again.";
        }
    }
}