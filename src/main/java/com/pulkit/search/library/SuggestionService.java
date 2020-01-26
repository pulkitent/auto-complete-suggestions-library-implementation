package com.pulkit.search.library;

import java.util.LinkedList;
import java.util.List;

class SuggestionService {
    private final TrieNode root;

    private final static char BASE_CONSTANT = 'a';
    private final static String EMPTY_STRING = "";

    SuggestionService() {
        root = new TrieNode(null);
    }

    List<String> getAllSuggestions(String searchText) {
        //TODO: To Be Implemented
        return null;
    }

    void addWordForSuggestions(String word) {
        addWordToTrie(word, 0, root);
    }

    List<String> getAllWords() {
        List<String> words = new LinkedList<>();
        Word emptyWord = new Word(EMPTY_STRING);

        getAllWordsFromTrie(words, emptyWord, root);
        return words;
    }

    private void getAllWordsFromTrie(List<String> words, Word currentWord, TrieNode node) {
        if (node.isLeafNode()) {
            String currentText = currentWord.text;
            words.add(currentText);

            currentWord.updateText(EMPTY_STRING);
            return;
        }

        TrieNode[] childs = node.getAllChilds();

        for (TrieNode child : childs) {
            if (child != null) {
                currentWord = child.addNodeCharacterToWord(currentWord);
                getAllWordsFromTrie(words, currentWord, child);
            }
        }
    }

    private void addWordToTrie(String word, int currentIndex, TrieNode root) {
        int wordLength = word.length();

        if (currentIndex >= wordLength)
            return;

        Character currentCharacter = word.charAt(currentIndex);
        int listIndex = convertCharacterToListIndexValue(currentCharacter);

        TrieNode node = root.getChildNode(listIndex);

        if (!root.isChildNodeAlreadyExist(listIndex)) {
            node = addTrieNodeToParent(currentIndex, root, wordLength, currentCharacter, listIndex);
        }

        addWordToTrie(word, currentIndex + 1, node);
    }

    private TrieNode addTrieNodeToParent(int currentIndex, TrieNode root, int wordLength,
                                         Character currentCharacter, int listIndex) {
        TrieNode node = new TrieNode(currentCharacter);

        if (currentIndex == wordLength - 1) {
            node.markAsLeafNode();
        }

        root.addChild(node, listIndex);
        return node;
    }

    private int convertCharacterToListIndexValue(Character givenCharacter) {
        Character firstCharacter = BASE_CONSTANT;
        return givenCharacter - firstCharacter;
    }
}