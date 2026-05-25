/*
 * ============================================
 * LoginSystem2 Application
 * Part 2: Sending Messages Feature
 *
 * This class handles:
 * - Message creation
 * - Message hash
 * - Message ID
 * - Message validation
 *
 * Author: Your Name
 * Date: 2026
 * ============================================
 */

package loginsystem2;

public class Message {

    private static int totalMessages = 0;

    // Generate Message ID
    public String generateMessageID() {

        String id =
                String.valueOf(
                        (long)(Math.random()
                        * 1000000000L)
                );

        while(id.length() < 10) {

            id = "0" + id;
        }

        return id;
    }

    // Check message ID
    public boolean checkMessageID(String id) {

        return id.length() <= 10;
    }

    // Check recipient number
    public boolean checkRecipientCell(String recipient) {

        return recipient.matches("^\\+27\\d{9}$");
    }

    // Validate message length
    public String validateMessage(String message) {

        if(message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extra = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extra;
        }
    }

    // Create message hash
    public String createMessageHash(
            int messageNumber,
            String messageID,
            String message) {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return messageID.substring(0,2)
                + ":"
                + messageNumber
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    // Send message options
    public String sentMessage(int option) {

        switch(option) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Return total messages
    public int returnTotalMessages() {

        return totalMessages;
    }
}