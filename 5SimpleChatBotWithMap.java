package abc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleChatBotWithMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create a Map to hold question keywords and answers
        HashMap<String, String> responses = new HashMap<>();
        responses.put("order", " You can check your order status at: www.shopease.com/track-order");
        responses.put("timing", " We are open from 9 AM to 9 PM, Monday to Saturday.");
        responses.put("open", "We are open from 9 AM to 9 PM, Monday to Saturday.");
        responses.put("contact", " You can contact our support team at support@shopease.com or call 1800-123-456.");
        responses.put("support", " You can contact our support team at support@shopease.com or call 1800-123-456.");

        System.out.println(" Hello! Welcome to ShopEase Customer Support.");
        System.out.println("How can I assist you today?");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.contains("bye")) {
                System.out.println(" Thank you for contacting ShopEase. Have a great day!");
                break;
            }

            boolean foundResponse = false;

            // Step 2: Search for a matching keyword
            for (String keyword : responses.keySet()) {
                if (userInput.contains(keyword)) {
                    System.out.println(responses.get(keyword));
                    foundResponse = true;
                    break;
                }
            }

            if (!foundResponse) {
                System.out.println("Sorry, I didn't understand that. Could you please rephrase?");
            }
        }

        scanner.close();
    }
}
