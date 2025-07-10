package com.lucy.utils;

import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.data.*;
import java.util.*;

public class SynonymResolver {
    private Dictionary dictionary;

    public SynonymResolver() throws Exception {
        dictionary = Dictionary.getDefaultResourceInstance(); // uses extjwnl properties
    }

    public Set<String> getSynonyms(String word) {
        Set<String> synonyms = new HashSet<>();

        try {
            IndexWord indexWord = dictionary.lookupIndexWord(POS.NOUN, word.toLowerCase());
            if (indexWord == null) return synonyms;

            for (Synset synset : indexWord.getSenses()) {
                for (Word w : synset.getWords()) {
                    synonyms.add(w.getLemma().replace('_', ' '));
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching synonyms: " + e.getMessage());
        }

        return synonyms;
    }
}
    