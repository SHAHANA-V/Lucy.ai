package com.lucy;

import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class IntentClassifier {
    private Map<String, List<String>> patternsMap;
    private Map<String, List<String>> responsesMap;

    public IntentClassifier() {
        patternsMap = new HashMap<>();
        responsesMap = new HashMap<>();
        loadIntents();
    }

    private void loadIntents() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(new FileReader("src/main/resources/intents.json"));
            JSONArray intents = (JSONArray) obj.get("intents");

            for (Object intentObj : intents) {
                JSONObject intent = (JSONObject) intentObj;
                String tag = (String) intent.get("tag");

                JSONArray patternsArray = (JSONArray) intent.get("patterns");
                List<String> patterns = new ArrayList<>();
                for (Object pattern : patternsArray) {
                    patterns.add(((String) pattern).toLowerCase());
                }

                JSONArray responsesArray = (JSONArray) intent.get("responses");
                List<String> responses = new ArrayList<>();
                for (Object response : responsesArray) {
                    responses.add((String) response);
                }

                patternsMap.put(tag, patterns);
                responsesMap.put(tag, responses);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String classifyIntent(String input) {
        input = input.toLowerCase();

        for (String tag : patternsMap.keySet()) {
            for (String pattern : patternsMap.get(tag)) {
                if (input.contains(pattern)) {
                    List<String> responses = responsesMap.get(tag);
                    if (responses != null && !responses.isEmpty()) {
                        return responses.get(new Random().nextInt(responses.size()));
                    }
                }
            }
        }
        return "Sorry, I didn't understand that.";
    }
}
