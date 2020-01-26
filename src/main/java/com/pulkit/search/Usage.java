package com.pulkit.search;

import com.pulkit.search.library.SearchSuggestionClient;

import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

class Usage {
    public static void main(String[] args) {
        SearchSuggestionClient client = new SearchSuggestionClient();

        addWordsToSuggestions(client);
        displayAllWords(client);
    }

    private static void displayAllSuggestionsForAParticularText(SearchSuggestionClient client) {
        List<String> allSuggestions = client.getAllSuggestions("pul");
        for (String word : allSuggestions) {
            out.println(word);
        }
    }

    private static void displayAllWords(SearchSuggestionClient client) {
        List<String> allWords = client.getAllWords();
        for (String word : allWords) {
            out.println(word);
        }
    }

    private static void addWordsToSuggestions(SearchSuggestionClient client) {
        List<String> words = asList("pulkit", "gupta", "teddy", "iklup");
        for (String word : words) {
            client.addWordForSuggestions(word);
        }
    }
}