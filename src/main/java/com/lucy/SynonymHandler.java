package com.lucy;

import java.util.*;

public class SynonymHandler {
    private static final Map<String, List<String>> synonymMap = new HashMap<>();

    static {
        synonymMap.put("hello", Arrays.asList("hi", "hey", "greetings"));
        synonymMap.put("bye", Arrays.asList("goodbye", "see you", "farewell"));
        synonymMap.put("thanks", Arrays.asList("thank you", "thx", "much appreciated"));
        synonymMap.put("help", Arrays.asList("support", "assist", "guide"));
    }

    public static String mapToIntent(String userInput) {
        String cleanedInput = userInput.toLowerCase();
        for (Map.Entry<String, List<String>> entry : synonymMap.entrySet()) {
            for (String synonym : entry.getValue()) {
                if (cleanedInput.contains(synonym)) {
                    return entry.getKey();
                }
            }
        }
        return userInput; // fallback to original
    }
}
