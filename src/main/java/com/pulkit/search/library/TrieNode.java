package com.pulkit.search.library;

import java.util.Objects;

class TrieNode {
    private final Character textCharacter;
    private final TrieNode[] childNodes = new TrieNode[26];
    private boolean isLeafNode;

    TrieNode(Character textCharacter) {
        this.textCharacter = textCharacter;
    }

    boolean isLeafNode() {
        return this.isLeafNode;
    }

    TrieNode[] getAllChilds() {
        return this.childNodes;
    }

    void addChild(TrieNode childNode, int position) {
        this.childNodes[position] = childNode;
    }

    Word addNodeCharacterToWord(Word word) {
        String text = this.textCharacter.toString();
        return word.addTextToCurrentWord(text);
    }

    void markAsLeafNode() {
        this.isLeafNode = true;
    }

    boolean isChildNodeAlreadyExist(int position) {
        return Objects.nonNull(this.childNodes[position]);
    }

    TrieNode getChildNode(int position) {
        return this.childNodes[position];
    }
}