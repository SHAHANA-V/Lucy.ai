package com.lucy;

import java.util.Scanner;

public class Lucy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntentClassifier classifier = new IntentClassifier();

        System.out.println("Hi, I'm Lucy 👩‍💻! How can I help you today?");

        while (true) {
            System.out.print("\nYou: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("bye") || userInput.equals("exit")) {
                System.out.println("Lucy: Goodbye! Have a nice day 😊");
                break;
            }

            String response = classifier.classify(userInput);
            System.out.println("Lucy: " + response);
        }

        scanner.close();
    }
}

