package com.pulkit.search.library;

import java.util.List;

public class SearchSuggestionClient {
    SuggestionService suggestionService;

    public SearchSuggestionClient() {
        this.suggestionService = new SuggestionService();
    }

    public List<String> getAllSuggestions(String searchText) {
        return suggestionService.getAllSuggestions(searchText);
    }

    public void addWordForSuggestions(String word) {
        suggestionService.addWordForSuggestions(word);
    }

    public List<String> getAllWords() {
        return suggestionService.getAllWords();
    }
}