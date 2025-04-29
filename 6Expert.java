package abc;
import java.util.*;

public class Expert {

    public static void main(String[] args) {
     
    	
    	
    	Scanner scanner = new Scanner(System.in);
        boolean status = true;

        while (status) {
            System.out.println("\nWelcome to the Medical Expert System!");
            System.out.println("Please answer the following questions with 'yes' or 'no'.\n");

            String fever = askQuestion(scanner, "Do you have a fever?");
            String cough = askQuestion(scanner, "Do you have a cough?");
            String breathShortness = askQuestion(scanner, "Do you experience shortness of breath?");
            String headache = askQuestion(scanner, "Do you have a headache?");
            String soreThroat = askQuestion(scanner, "Do you have a sore throat?");
            String bodyPain = askQuestion(scanner, "Do you have body pain?");

            System.out.println("\nAnalyzing your symptoms...\n");

            if (fever.equals("yes") && cough.equals("yes") && breathShortness.equals("yes")) {
                System.out.println("Possible Diagnosis: COVID-19 or similar respiratory infection.");
                System.out.println(" Advice: Get a COVID test and consult a doctor immediately.");
            } else if (fever.equals("yes") && headache.equals("yes") && bodyPain.equals("yes")) {
                System.out.println("Possible Diagnosis: Dengue Fever or Flu.");
                System.out.println("Advice: Get a blood test and drink plenty of fluids. See a doctor.");
            } else if (soreThroat.equals("yes") && cough.equals("yes")) {
                System.out.println("Possible Diagnosis: Common Cold or Throat Infection.");
                System.out.println("Advice: Take rest, drink warm liquids, and consult a doctor if condition worsens.");
            } else {
                System.out.println("No major disease detected based on provided symptoms.");
                System.out.println("Advice: Maintain good health habits and visit a doctor if you feel worse.");
            }

            System.out.println("\nWould you like to diagnose again? (yes/no)");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                status = false;
            }
        }

        System.out.println("\nThank you for using the Expert System. Stay Healthy!");
        scanner.close();
    }

    public static String askQuestion(Scanner scanner, String question) {
        while (true) {
            System.out.print(question + " ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("no")) {
                return answer;
            } else {
                System.out.println("❗ Invalid input. Please answer only 'yes' or 'no'.");
            }
        }
    }
}
