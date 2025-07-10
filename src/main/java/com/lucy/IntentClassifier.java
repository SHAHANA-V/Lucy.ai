package com.lucy;

public class IntentClassifier {

    public String classify(String userInput) {
        if (userInput.contains("hello") || userInput.contains("hi") || userInput.contains("hey")) {
            return "Hello! How can I assist you?";
        }

        else if (userInput.contains("your name")) {
            return "My name is Lucy, your smart assistant 🤖.";
        }

        else if (userInput.contains("help") || userInput.contains("support")) {
            return "Sure, I can help you. Please describe your problem.";
        }

        else if (userInput.contains("time")) {
            return "I'm not wearing a watch, but your system clock knows the answer! 😉";
        }

        else if (userInput.contains("joke")) {
            return "Why don’t scientists trust atoms? Because they make up everything! 😄";
        }

        else if (userInput.contains("weather")) {
            return "I can't check the weather yet, but it’s always sunny when we talk! ☀️";
        }

        else {
            return "Hmm, I didn’t quite get that. Could you rephrase or ask something else?";
        }
    }
}



