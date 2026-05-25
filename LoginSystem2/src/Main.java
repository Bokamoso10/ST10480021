/*
 * ============================================
 * LoginSystem2 Application
 * Part 1: Registration and Login Feature
 * Part 2: Sending Messages Feature
 *
 * Main class:
 * - Accepts user input
 * - Displays output
 * - Controls application flow
 *
 * Author: Your Name
 * Date: 2026
 * ============================================
 */

package loginsystem2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LoginSystem2 login = new LoginSystem2();

        // Registration section
        System.out.println("===== REGISTRATION =====");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone (+27...): ");
        String cellphone = input.nextLine();

        String registrationMessage =
                login.registerUser(
                        username,
                        password,
                        cellphone,
                        firstName,
                        lastName
                );

        System.out.println(registrationMessage);

        // Stop if registration fails
        if (!registrationMessage.equals(
                "User successfully registered.")) {

            return;
        }

        // Login section
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        boolean loginSuccess =
                login.loginUser(
                        loginUsername,
                        loginPassword
                );

        System.out.println(
                login.returnLoginStatus(loginSuccess)
        );

        input.close();
    }
}